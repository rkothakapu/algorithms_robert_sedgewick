package fundamentals.union_find;

// Quick Union
public class UnionFindImpl {
    protected int[] id; // access to component id
    protected int count; // number of components


    public UnionFindImpl(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int x = p;
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j) return;;

        id[i] = j;
        count--;
    }
    

}
