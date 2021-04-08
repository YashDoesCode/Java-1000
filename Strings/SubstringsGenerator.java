import java.util.*;
public class SubstringsGenerator {

    public List<String> getAllSubstrings(String s) { List<String> res = new ArrayList<>();
        for (int i = 0;
        i < s.length();
        i++) for (int j = i + 1;
        j <= s.length();
        j++) res.add(s.substring(i, j));
        return res;
    };
}
