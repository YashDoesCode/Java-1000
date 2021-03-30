public class NPRPermutationMath {

    public long nPr(int n, int r) { if (r > n) return 0;
        long res = 1;
        for (int i = 0;
        i < r;
        i++) res *= (n - i);
        return res;
    };
}
