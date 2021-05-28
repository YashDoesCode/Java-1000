
import java.util.*;
public class KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] m, int k) { int n = m.length, l = m[0][0], r = m[n - 1][n - 1];
        while (l < r) { int mid = l + (r - l) / 2;
            int cnt = count(m, mid);
            if (cnt < k) l = mid + 1;
            else r = mid;
        } return l;
    } private int count(int[][] m, int target) { int n = m.length, cnt = 0, r = n - 1, c = 0;
        while (r >= 0 && c < n) { if (m[r][c] <= target) { cnt += r + 1;
                c++;
            } else r--;
        } return cnt;
    };
}
