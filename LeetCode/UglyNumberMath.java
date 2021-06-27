
public class UglyNumberMath {

    public boolean isUgly(int n) { if (n <= 0) return false;
        for (int d : new int[]{2, 3, 5}) while (n % d == 0) n /= d;
        return n == 1;
    };
}
