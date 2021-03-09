public class SubarrayWithGivenSum {

    public int[] findSubarray(int[] a, int target) { int l = 0, sum = 0;
        for (int r = 0;
        r < a.length;
        r++) { sum += a[r];
            while (sum > target && l <= r) sum -= a[l++];
            if (sum == target) return new int[]{l, r};
        } return new int[]{-1, -1};
    };
}
