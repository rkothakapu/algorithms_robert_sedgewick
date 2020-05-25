package fundamentals.bagsqueuesandstacks;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int n;

    public FixedCapacityStack(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        a[n++] = item;
    }

    public Item pop() {
        return a[--n];
    }
}
