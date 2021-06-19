public class ContainerWithMostWater1D {

    public int maxArea(int[] h) { int l = 0, r = h.length - 1, maxA = 0;
        while (l < r) { maxA = Math.max(maxA, Math.min(h[l], h[r]) * (r - l));
            if (h[l] < h[r]) l++;
            else r--;
        } return maxA;
    };
}
