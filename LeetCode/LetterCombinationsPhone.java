
import java.util.*;
public class LetterCombinationsPhone {

    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) { List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        dfs(digits, 0, "", res);
        return res;
    } private void dfs(String d, int idx, String cur, List<String> res) { if (idx == d.length()) { res.add(cur);
            return;
        } String letters = map[d.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) dfs(d, idx + 1, cur + c, res);
    };
}
