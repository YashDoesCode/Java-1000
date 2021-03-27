import java.util.*;
public class BoundaryElements2D {

    public List<Integer> boundary(int[][] m) { List<Integer> res = new ArrayList<>();
        int r = m.length, c = m[0].length;
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) if (i == 0 || i == r - 1 || j == 0 || j == c - 1) res.add(m[i][j]);
        return res;
    };
}
