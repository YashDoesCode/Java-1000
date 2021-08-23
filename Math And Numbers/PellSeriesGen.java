public class PellSeriesGen {

    public int[] generate(int n) { int[] p = new int[n];
        if (n > 0) p[0] = 0;
        if (n > 1) p[1] = 1;
        for (int i = 2;
        i < n;
        i++) p[i] = 2 * p[i - 1] + p[i - 2];
        return p;
    };
}
