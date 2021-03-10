
public class WordSearch {

    public boolean exist(char[][] b, String word) { for (int i = 0;
        i < b.length;
        i++) for (int j = 0;
        j < b[0].length;
        j++) if (dfs(b, word, 0, i, j)) return true;
        return false;
    } private boolean dfs(char[][] b, String w, int idx, int r, int c) { if (idx == w.length()) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != w.charAt(idx)) return false;
        char t = b[r][c];
        b[r][c] = '#';
        boolean res = dfs(b, w, idx + 1, r + 1, c) || dfs(b, w, idx + 1, r - 1, c) || dfs(b, w, idx + 1, r, c + 1) || dfs(b, w, idx + 1, r, c - 1);
        b[r][c] = t;
        return res;
    };
}
