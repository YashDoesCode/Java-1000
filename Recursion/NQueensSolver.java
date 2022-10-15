import java.util.*;

public class NQueensSolver {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(res, board, 0, n);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int col, int n) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(new String(board[i]));
            res.add(list);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(res, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) if (board[row][i] == 'Q') return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row, j = col; i < n && j >= 0; i++, j--) if (board[i][j] == 'Q') return false;
        return true;
    }
}
