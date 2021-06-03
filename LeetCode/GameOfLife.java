
public class GameOfLife {

    public void gameOfLife(int[][] b) { int r = b.length, c = b[0].length;
        for (int i = 0;
        i < r;
        i++) { for (int j = 0;
            j < c;
            j++) { int nbrs = count(b, i, j);
                if (b[i][j] == 1 && (nbrs == 2 || nbrs == 3)) b[i][j] = 3;
                if (b[i][j] == 0 && nbrs == 3) b[i][j] = 2;
            } } for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) b[i][j] >>= 1;
    } private int count(int[][] b, int r, int c) { int cnt = 0;
        for (int i = Math.max(0, r - 1);
        i <= Math.min(b.length - 1, r + 1);
        i++) for (int j = Math.max(0, c - 1);
        j <= Math.min(b[0].length - 1, c + 1);
        j++) cnt += b[i][j] & 1;
        return cnt - (b[r][c] & 1);
    };
}
