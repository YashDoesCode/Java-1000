
public class CatalanNumbersMath {

    public long catalan(int n) { long[] c = new long[n + 1];
        c[0] = 1;
        for (int i = 1;
        i <= n;
        i++) for (int j = 0;
        j < i;
        j++) c[i] += c[j] * c[i - 1 - j];
        return c[n];
    };
}
