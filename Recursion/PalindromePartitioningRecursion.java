import java.util.*;
public class PalindromePartitioningRecursion {

    public List<List<String>> partition(String s) { List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    } private void dfs(String s, int start, List<String> cur, List<List<String>> res) { if (start == s.length()) { res.add(new ArrayList<>(cur));
            return;
        } for (int i = start;
        i < s.length();
        i++) if (isPal(s, start, i)) { cur.add(s.substring(start, i + 1));
            dfs(s, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        } } private boolean isPal(String s, int l, int r) { while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    };
}
