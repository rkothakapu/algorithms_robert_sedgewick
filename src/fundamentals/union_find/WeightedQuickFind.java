package fundamentals.union_find;

public class WeightedQuickFind extends UnionFindImpl{
    private int[] size;

    public WeightedQuickFind(int n) {
        super(n);
        size = new int[n];
        for(int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j) return;

        if(size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }

        find(0);

        count--;
    }
}
