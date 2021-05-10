
public class ContainerWater {

    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1, maxV = 0;
        while (l < r) {
            int area = Math.min(h[l], h[r]) * (r - l);
            maxV = Math.max(maxV, area);
            if (h[l] < h[r]) l++;
            else r--;
        }
        return maxV;
    }
}
