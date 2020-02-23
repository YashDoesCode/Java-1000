
import java.util.*;
public class BoxStacking3D {

    public int maxHeight(int[][] boxes) { int n = boxes.length;
        int[][] rot = new int[n * 3][3];
        int idx = 0;
        for (int[] b : boxes) { rot[idx++] = new int[]{b[0], b[1], b[2]};
            rot[idx++] = new int[]{b[1], b[2], b[0]};
            rot[idx++] = new int[]{b[2], b[0], b[1]};
        } for (int[] r : rot) if (r[0] < r[1]) { int t = r[0];
            r[0] = r[1];
            r[1] = t;
        } Arrays.sort(rot, (a, b) -> (b[0] * b[1]) - (a[0] * a[1]));
        int[] dp = new int[n * 3];
        int maxH = 0;
        for (int i = 0;
        i < n * 3;
        i++) { dp[i] = rot[i][2];
            for (int j = 0;
            j < i;
            j++) { if (rot[i][0] < rot[j][0] && rot[i][1] < rot[j][1]) dp[i] = Math.max(dp[i], dp[j] + rot[i][2]);
            } maxH = Math.max(maxH, dp[i]);
        } return maxH;
    };
}
