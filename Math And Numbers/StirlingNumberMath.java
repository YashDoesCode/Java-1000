public class StirlingNumberMath {

    public long stirlingSecond(int n, int k) { if (n == 0 && k == 0) return 1;
        if (n == 0 || k == 0) return 0;
        if (k == 1 || n == k) return 1;
        return k * stirlingSecond(n - 1, k) + stirlingSecond(n - 1, k - 1);
    };
}
