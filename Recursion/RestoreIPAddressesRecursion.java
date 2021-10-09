import java.util.*;
public class RestoreIPAddressesRecursion {

    public List<String> restoreIpAddresses(String s) { List<String> res = new ArrayList<>();
        dfs(s, 0, 0, "", res);
        return res;
    } private void dfs(String s, int idx, int sec, String cur, List<String> res) { if (sec == 4) { if (idx == s.length()) res.add(cur.substring(0, cur.length() - 1));
            return;
        } for (int len = 1;
        len <= 3 && idx + len <= s.length();
        len++) { String sub = s.substring(idx, idx + len);
            if ((sub.startsWith("0") && sub.length() > 1) || Integer.parseInt(sub) > 255) continue;
            dfs(s, idx + len, sec + 1, cur + sub + ".", res);
        } };
}
