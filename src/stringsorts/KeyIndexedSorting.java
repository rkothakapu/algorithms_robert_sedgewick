package stringsorts;

public class KeyIndexedSorting {
    private class A{
        int key;
        String val;
    }

    public void sort(A[] a, int R) {
        int [] count = new int[R+1];
        for(int i = 0; i < a.length; i++) {
            count[a[i].key + 1]++;
        }

        for(int r = 0; r < R; r++)
            count[r+1] += count[r];

        A[] aux = new A[a.length];
        for(int i = 0; i < a.length; i++)
            aux[count[a[i].key]++] = a[i];

        a = aux;
    }
}
