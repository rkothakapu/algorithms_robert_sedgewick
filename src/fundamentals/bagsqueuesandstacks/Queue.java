package fundamentals.bagsqueuesandstacks;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
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

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty()) last = null;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

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
