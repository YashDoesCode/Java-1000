public class LucasSeriesGen {

    public int[] generate(int n) { int[] l = new int[n];
        if (n > 0) l[0] = 2;
        if (n > 1) l[1] = 1;
        for (int i = 2;
        i < n;
        i++) l[i] = l[i - 1] + l[i - 2];
        return l;
    };
}
