
public class UglyNumberIIMath {

    public int nthUglyNumber(int n) { int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1;
        i < n;
        i++) { int nxt2 = ugly[i2] * 2, nxt3 = ugly[i3] * 3, nxt5 = ugly[i5] * 5;
            int nxt = Math.min(nxt2, Math.min(nxt3, nxt5));
            ugly[i] = nxt;
            if (nxt == nxt2) i2++;
            if (nxt == nxt3) i3++;
            if (nxt == nxt5) i5++;
        } return ugly[n - 1];
    };
}
