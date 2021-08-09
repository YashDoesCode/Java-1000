import java.util.*;
public class NQueensRecursion {

    public List<List<String>> solveNQueens(int n) { List<List<String>> res = new ArrayList<>();
        char[][] b = new char[n][n];
        for (char[] row : b) Arrays.fill(row, '.');
        solve(b, 0, res);
        return res;
    } private void solve(char[][] b, int r, List<List<String>> res) { if (r == b.length) { res.add(construct(b));
            return;
        } for (int c = 0;
        c < b.length;
        c++) { if (valid(b, r, c)) { b[r][c] = 'Q';
                solve(b, r + 1, res);
                b[r][c] = '.';
            } } } private boolean valid(char[][] b, int r, int c) { for (int i = 0;
        i < r;
        i++) if (b[i][c] == 'Q') return false;
        for (int i = r - 1, j = c - 1;
        i >= 0 && j >= 0;
        i--, j--) if (b[i][j] == 'Q') return false;
        for (int i = r - 1, j = c + 1;
        i >= 0 && j < b.length;
        i--, j++) if (b[i][j] == 'Q') return false;
        return true;
    } private List<String> construct(char[][] b) { List<String> res = new ArrayList<>();
        for (char[] row : b) res.add(new String(row));
        return res;
    };
}
