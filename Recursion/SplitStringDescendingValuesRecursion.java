public class SplitStringDescendingValuesRecursion {

    public boolean splitString(String s) { for (int i = 1;
        i < s.length();
        i++) { long val = Long.parseLong(s.substring(0, i));
            if (dfs(s, i, val)) return true;
        } return false;
    } private boolean dfs(String s, int idx, long prev) { if (idx == s.length()) return true;
        long val = 0;
        for (int i = idx;
        i < s.length();
        i++) { val = val * 10 + (s.charAt(i) - '0');
            if (val == prev - 1) { if (dfs(s, i + 1, val)) return true;
            } else if (val >= prev) break;
        } return false;
    };
}
