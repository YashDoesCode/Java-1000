
public class PascalCombinationMath {

    public long nCr(int n, int r) { if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        long res = 1;
        for (int i = 1;
        i <= r;
        i++) { res = res * (n - i + 1) / i;
        } return res;
    };
}
