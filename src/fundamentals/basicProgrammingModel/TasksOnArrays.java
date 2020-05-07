package fundamentals.basicProgrammingModel;

public class TasksOnArrays {

    public int findMax(int[] arr) {
        if(arr.length < 1) { throw new RuntimeException("Array doesn't contain any elements"); }
        int max = arr[0];
        for(int idx = 0; idx < arr.length; idx++)
            max = arr[idx] > max? arr[idx] : max;
        return max;
    }

    public double computeAverage(int[] arr) {
        if(arr.length < 1) { throw new RuntimeException("Array doesn't contain any elements"); }
        double sum = 0.0;
        for(int idx = 0; idx < arr.length; idx++)
            sum += arr[idx];
        return sum / arr.length;
    }

    public void reverseTheElementsWithinAnArray(int [] arr) {
        int length = arr.length;
        for(int idx = 0; idx < length/2; idx++) {
            int temp = arr[idx];
            arr[idx] = arr[length-idx];
            arr[length-idx] = temp;
        }
    }

    public double[][] matrixToMatrixMultiplication(double[][] a, double[][] b) {
        int size = a.length;
        double[][] c = new double[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }
}
