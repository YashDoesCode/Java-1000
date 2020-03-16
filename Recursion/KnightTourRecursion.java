public class KnightTourRecursion {

    public boolean solveKT(int n) { int[][] board = new int[n][n];
        for (int i = 0;
        i < n;
        i++) for (int j = 0;
        j < n;
        j++) board[i][j] = -1;
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        board[0][0] = 0;
        return solve(0, 0, 1, board, xMove, yMove, n);
    } private boolean solve(int x, int y, int movei, int[][] b, int[] xMove, int[] yMove, int n) { if (movei == n * n) return true;
        for (int k = 0;
        k < 8;
        k++) { int nx = x + xMove[k], ny = y + yMove[k];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && b[nx][ny] == -1) { b[nx][ny] = movei;
                if (solve(nx, ny, movei + 1, b, xMove, yMove, n)) return true;
                b[nx][ny] = -1;
            } } return false;
    };
}
