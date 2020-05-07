package searching;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if(x == null) return 0;
        else return x.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if( x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        if(cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Key min() {
        if(isEmpty()) throw new NoSuchElementException();
        Node x = min(root);
        return x.key;
    }

    private Node min(Node x) {
        if(x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if(x == null) throw new NoSuchElementException();
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t != null) return t;
        else return x;
    }

    public Key select(int k) {
        if(k < 0 || k >=size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if(x == null) return null;
        int t = size(x.left);
        if(t > k) return select(x.left, k);
        else if(t < k) return select(x.right, t-k-1);
        else return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left, key);
        else if(cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }
}
