
import java.util.*;
public class LuckyNumbersMatrix {

    public List<Integer> luckyNumbers (int[][] m) { int r = m.length, c = m[0].length;
        int[] rMin = new int[r], cMax = new int[c];
        Arrays.fill(rMin, Integer.MAX_VALUE);
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) { rMin[i] = Math.min(rMin[i], m[i][j]);
            cMax[j] = Math.max(cMax[j], m[i][j]);
        } List<Integer> res = new ArrayList<>();
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) if (m[i][j] == rMin[i] && m[i][j] == cMax[j]) res.add(m[i][j]);
        return res;
    };
}
