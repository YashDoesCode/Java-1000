public class TrappingRainWater1D {

    public int trap(int[] h) { int l = 0, r = h.length - 1, leftMax = 0, rightMax = 0, ans = 0;
        while (l < r) { if (h[l] < h[r]) { if (h[l] >= leftMax) leftMax = h[l];
                else ans += leftMax - h[l];
                l++;
            } else { if (h[r] >= rightMax) rightMax = h[r];
                else ans += rightMax - h[r];
                r--;
            } } return ans;
    };
}
