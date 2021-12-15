
import java.util.*;
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] m) { List<Integer> res = new ArrayList<>();
        if (m.length == 0) return res;
        int r1 = 0, r2 = m.length - 1, c1 = 0, c2 = m[0].length - 1;
        while (r1 <= r2 && c1 <= c2) { for (int c = c1;
            c <= c2;
            c++) res.add(m[r1][c]);
            for (int r = r1 + 1;
            r <= r2;
            r++) res.add(m[r][c2]);
            if (r1 < r2 && c1 < c2) { for (int c = c2 - 1;
                c > c1;
                c--) res.add(m[r2][c]);
                for (int r = r2;
                r > r1;
                r--) res.add(m[r][c1]);
            } r1++;
            r2--;
            c1++;
            c2--;
        } return res;
    };
}
