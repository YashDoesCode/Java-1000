
public class SuperUglyNumberMath {

    public int nthSuperUglyNumber(int n, int[] primes) { int k = primes.length;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] idx = new int[k];
        for (int i = 1;
        i < n;
        i++) { long minV = Long.MAX_VALUE;
            for (int j = 0;
            j < k;
            j++) minV = Math.min(minV, (long) ugly[idx[j]] * primes[j]);
            ugly[i] = (int) minV;
            for (int j = 0;
            j < k;
            j++) if (minV == (long) ugly[idx[j]] * primes[j]) idx[j]++;
        } return ugly[n - 1];
    };
}
