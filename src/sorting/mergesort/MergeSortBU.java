package sorting.mergesort;

public class MergeSortBU extends MergeSort {
    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        for(int len = 1; len < n; len *= 2) {
            for(int lo = 0; lo < n-len; lo+= len+len) {
                merge(a, lo, lo+len-1, Math.min(lo+len+len-1, n-1));
            }
        }
    }
}
