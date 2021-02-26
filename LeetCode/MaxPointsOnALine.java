
import java.util.*;
public class MaxPointsOnALine {

    public int maxPoints(int[][] points) { int n = points.length;
        if (n <= 2) return n;
        int ans = 0;
        for (int i = 0;
        i < n;
        i++) { Map<String, Integer> mp = new HashMap<>();
            int same = 1, maxP = 0;
            for (int j = i + 1;
            j < n;
            j++) { int dx = points[j][0] - points[i][0], dy = points[j][1] - points[i][1];
                int g = gcd(dx, dy);
                String slope = (dx / g) + "/" + (dy / g);
                mp.put(slope, mp.getOrDefault(slope, 0) + 1);
                maxP = Math.max(maxP, mp.get(slope));
            } ans = Math.max(ans, maxP + same);
        } return ans;
    } private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b);
    };
}
