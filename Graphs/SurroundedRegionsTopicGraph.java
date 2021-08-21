public class SurroundedRegionsTopicGraph {

    public void solve(char[][] board) { int r = board.length, c = board[0].length;
        for (int i = 0;
        i < r;
        i++) { dfs(board, i, 0);
            dfs(board, i, c - 1);
        } for (int j = 0;
        j < c;
        j++) { dfs(board, 0, j);
            dfs(board, r - 1, j);
        } for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) { if (board[i][j] == 'O') board[i][j] = 'X';
            else if (board[i][j] == 'E') board[i][j] = 'O';
        } } private void dfs(char[][] b, int r, int c) { if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != 'O') return;
        b[r][c] = 'E';
        dfs(b, r + 1, c);
        dfs(b, r - 1, c);
        dfs(b, r, c + 1);
        dfs(b, r, c - 1);
    };
}
