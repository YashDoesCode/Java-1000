public class TribonacciSeriesGen {

    public int[] generate(int n) { int[] t = new int[n];
        if (n > 0) t[0] = 0;
        if (n > 1) t[1] = 1;
        if (n > 2) t[2] = 1;
        for (int i = 3;
        i < n;
        i++) t[i] = t[i - 1] + t[i - 2] + t[i - 3];
        return t;
    };
}
