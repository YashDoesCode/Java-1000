public class ChineseRemainderTheorem {

    public int crt(int[] num, int[] rem) { int prod = 1;
        for (int n : num) prod *= n;
        int result = 0;
        for (int i = 0;
        i < num.length;
        i++) { int pp = prod / num[i];
            result += rem[i] * modInverse(pp, num[i]) * pp;
        } return result % prod;
    } private int modInverse(int a, int m) { a %= m;
        for (int x = 1;
        x < m;
        x++) if ((a * x) % m == 1) return x;
        return 1;
    };
}
