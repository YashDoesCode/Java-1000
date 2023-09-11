public class MaximumSubarrayKadane {

    public int maxSubArray(int[] a) { int maxSoFar = a[0], curMax = a[0];
        for (int i = 1;
        i < a.length;
        i++) { curMax = Math.max(a[i], curMax + a[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        } return maxSoFar;
    };
}
