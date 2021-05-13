public class FindMinAndMax1D {

    public int[] getMinMax(int[] a) { int minV = a[0], maxV = a[0];
        for (int x : a) { if (x < minV) minV = x;
            if (x > maxV) maxV = x;
        } return new int[]{minV, maxV};
    };
}
