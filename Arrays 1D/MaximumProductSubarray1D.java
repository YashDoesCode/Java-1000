public class MaximumProductSubarray1D {

    public int maxProduct(int[] a) { int res = a[0], maxP = a[0], minP = a[0];
        for (int i = 1;
        i < a.length;
        i++) { if (a[i] < 0) { int t = maxP;
                maxP = minP;
                minP = t;
            } maxP = Math.max(a[i], maxP * a[i]);
            minP = Math.min(a[i], minP * a[i]);
            res = Math.max(res, maxP);
        } return res;
    };
}
