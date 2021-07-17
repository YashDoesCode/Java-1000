
import java.util.*;
public class RussianDollEnvelopesDP {

    public int maxEnvelopes(int[][] env) { Arrays.sort(env, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int[] tails = new int[env.length];
        int len = 0;
        for (int[] e : env) { int x = e[1];
            int i = 0, j = len;
            while (i < j) { int mid = (i + j) / 2;
                if (tails[mid] < x) i = mid + 1;
                else j = mid;
            } tails[i] = x;
            if (i == len) len++;
        } return len;
    };
}
