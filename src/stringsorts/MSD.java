package stringsorts;

public class MSD{
    private static int R = 256;
    private static final int CUTOFF = 15;
    private static String[] aux;

    private static int charAt(String s, int d) {
        return d < s.length()? s.charAt(d) : -1;
    }

    public static void sort(String[] a) {
        int n = a.length;
        aux = new String[n];
        sort(a, 0, n-1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if(hi <= lo+CUTOFF) {
            sort(a, lo, hi, d); return;
        }

        int [] count = new int[R+2];
        for(int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for(int r = 0; r < R+1; r++) {
            count[r+1] += count[r];
        }

        for(int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];

        for(int i = lo; i <= hi; i++)
            a[i] = aux[i-lo];
    }
}
