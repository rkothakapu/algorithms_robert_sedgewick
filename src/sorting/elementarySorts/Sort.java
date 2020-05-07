package sorting.elementarySorts;

public abstract class Sort {
    public static void sort(Comparable[] a) {
        // Implementations in the child classes
    }

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static boolean isSorted(Comparable[] a){
        if(a == null || a.length ==0 ) { throw new RuntimeException(); }
        if(a.length == 1) return  true;

        for(int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }

        return true;
    }
}
