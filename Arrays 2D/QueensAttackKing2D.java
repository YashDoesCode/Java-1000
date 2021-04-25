import java.util.*;
public class QueensAttackKing2D {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) { List<List<Integer>> res = new ArrayList<>();
        boolean[][] b = new boolean[8][8];
        for (int[] q : queens) b[q[0]][q[1]] = true;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0;
        i < 8;
        i++) { int x = king[0] + dx[i], y = king[1] + dy[i];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) { if (b[x][y]) { res.add(Arrays.asList(x, y));
                    break;
                } x += dx[i];
                y += dy[i];
            } } return res;
    };
}
