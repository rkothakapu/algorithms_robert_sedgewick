package sorting.quicksort;

import sorting.elementarySorts.Sort;

public class QuickSort extends Sort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true) {
            while(less(a[++i], v)) if(i == hi) break;
            while (less(v, a[--j])) if(j == lo) break;
            if(i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }
}
