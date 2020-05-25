package searching;

public class SequentialSearchST<Key, Value> {
    private Node first;

    public void delete(Key key) {
        if(first.key.equals(key)) {
            first = first.next;
            return;
        }

        for(Node x = first; x.next != null; x = x.next) {
            if(x.next.key.equals(key)) {
                x.next = x.next.next;
                return;
            }
        }
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x!= null; x = x.next) {
            if(key.equals(x.key)) {
                x.value = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public boolean contains(Key key) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                return true;
            }
        }
        return false;
    }
}
