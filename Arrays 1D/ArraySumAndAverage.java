public class ArraySumAndAverage {

    public double[] calc(int[] a) { int sum = 0;
        for (int x : a) sum += x;
        return new double[]{sum, (double) sum / a.length};
    };
}
