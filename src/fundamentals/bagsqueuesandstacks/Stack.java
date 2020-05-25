package fundamentals.bagsqueuesandstacks;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        public boolean hasNext() {
            return first != null;
        }

        public void remove() {}

        public Item next() {
            Item item = first.item;
            first = first.next;
            return item;
        }
    }
}
