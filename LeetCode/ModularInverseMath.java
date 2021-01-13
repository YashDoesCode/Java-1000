
public class ModularInverseMath {

    public long modInverse(long a, long m) { return power(a, m - 2, m);
    } private long power(long base, long exp, long mod) { long res = 1;
        base %= mod;
        while (exp > 0) { if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        } return res;
    };
}
