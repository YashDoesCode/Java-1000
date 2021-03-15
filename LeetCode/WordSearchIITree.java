
import java.util.*;
public class WordSearchIITree {

    class Node { Node[] next = new Node[26];

        String word;
    } public List<String> findWords(char[][] board, String[] words) { Node root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0;
        i < board.length;
        i++) for (int j = 0;
        j < board[0].length;
        j++) dfs(board, i, j, root, res);
        return res;
    } private void dfs(char[][] b, int r, int c, Node p, List<String> res) { char ch = b[r][c];
        if (ch == '#' || p.next[ch - 'a'] == null) return;
        p = p.next[ch - 'a'];
        if (p.word != null) { res.add(p.word);
            p.word = null;
        } b[r][c] = '#';
        if (r > 0) dfs(b, r - 1, c, p, res);
        if (c > 0) dfs(b, r, c - 1, p, res);
        if (r < b.length - 1) dfs(b, r + 1, c, p, res);
        if (c < b[0].length - 1) dfs(b, r, c + 1, p, res);
        b[r][c] = ch;
    } private Node buildTrie(String[] words) { Node root = new Node();
        for (String w : words) { Node p = root;
            for (char c : w.toCharArray()) { int idx = c - 'a';
                if (p.next[idx] == null) p.next[idx] = new Node();
                p = p.next[idx];
            } p.word = w;
        } return root;
    };
}
