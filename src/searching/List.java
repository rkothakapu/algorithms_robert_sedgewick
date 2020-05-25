package searching;

import java.util.EmptyStackException;
import java.util.Iterator;

public class List<Item extends Comparable<Item>> implements Iterable<Item> {
    /*
   Hint: Use two symbol tables, one to find the ith element in the list efficiently, and the other
   to efficiently search by item.
     */
    SeparateChainingHashST<Item, Integer> searchByItemTable;
    SeparateChainingHashST<Integer, Item> searchByIndexTable;
    int frontIdx;
    int backIdx;
    int size;

    public List(){
        searchByItemTable = new SeparateChainingHashST<>();
        searchByIndexTable = new SeparateChainingHashST<>();
        frontIdx = 0;
        backIdx = 0;
        size = 0;
    }

    void addFront(Item item) {
        if(size != 0) {
            frontIdx--;
        }

        // If the item already exists, delete the item
        if(contains(item)) {
            delete(item);
        }
        searchByItemTable.put(item, frontIdx);
        searchByIndexTable.put(frontIdx, item);
    }

    void addBack(Item item) {
        if(size != 0) {
            backIdx++;
        }

        // If the item already exists, delete the item
        if(contains(item)) {
            delete(item);
        }
        searchByItemTable.put(item, backIdx);
        searchByIndexTable.put(backIdx, item);
    }

    Item deleteFront() {
        if(size == 0) throw new EmptyStackException();

        Item item = searchByIndexTable.get(frontIdx);
        searchByItemTable.delete(item);
        searchByIndexTable.delete(frontIdx);
        frontIdx++;
        size--;
        return item;
    }

    Item deleteBack() {
        if(size == 0) throw new EmptyStackException();

        Item item = searchByIndexTable.get(backIdx);
        searchByItemTable.delete(item);
        searchByIndexTable.delete(backIdx);
        backIdx++;
        size--;
        return item;
    }

    void delete(Item item) {
        if(!contains(item)) return;

        int idx = searchByItemTable.get(item);
        delete(idx);
    }

    void add(int idx, Item item) {
        if( (idx - frontIdx) < (backIdx - idx)) {
            for(int i = idx; i >= frontIdx; i--) {
                Item temp = searchByIndexTable.get(i);
                searchByIndexTable.put(i-1, temp);
                searchByItemTable.put(temp, i-1);
            }
            frontIdx--;
        } else{
            for(int i = idx; i <= backIdx; i++) {
                Item temp = searchByIndexTable.get(i);
                searchByIndexTable.put(i+1, temp);
                searchByItemTable.put(temp, i+1);
            }
            backIdx++;
        }

        searchByItemTable.put(item, idx);
        searchByIndexTable.put(idx, item);
        size++;
    }

    Item delete(int idx) {
        Item item = searchByIndexTable.get(idx);

        if( (idx - frontIdx) < (backIdx - idx)) {
            for(int i = idx-1; i >= frontIdx; i--) {
                Item temp = searchByIndexTable.get(i);
                searchByIndexTable.put(i+1, temp);
                searchByItemTable.put(temp, i+1);
            }
            frontIdx++;
        } else{
            for(int i = idx+1; i <= backIdx; i++) {
                Item temp = searchByIndexTable.get(i);
                searchByIndexTable.put(i-1, temp);
                searchByItemTable.put(temp, i-1);
            }
            backIdx--;
        }
        size--;

        return item;
    }

    boolean contains(Item item){
        return searchByItemTable.contains(item);
    }

    boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Item> {
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            return searchByIndexTable.get(i++);
        }
    }
}