package sorting.elementarySorts;

public class InsertionSort extends Sort{

    public static void sort(Comparable[] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exchange(a, j, j-1);
            }
        }
        if(!isSorted(a)) {throw new RuntimeException("Sorting is incorrect"); }
    }

}
