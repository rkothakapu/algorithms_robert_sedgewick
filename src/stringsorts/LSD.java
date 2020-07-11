package stringsorts;

public class LSD {
    public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 256;
        String[] aux = new String[n];

        for(int d = w-1; d >= 0; d--) {
            int[] count = new int[R+1];
            for(int i = 0; i < n; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            for(int r = 0; r < R; r++)
                count[r+1] += count[r];

            for(int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            for(int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }
}
