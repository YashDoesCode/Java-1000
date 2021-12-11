public class ConcatenationBinaryBit {

    public int concatenatedBinary(int n) { long res = 0, mod = 1000000007, len = 0;
        for (int i = 1;
        i <= n;
        i++) { if ((i & (i - 1)) == 0) len++;
            res = ((res << len) + i) % mod;
        } return (int) res;
    };
}
