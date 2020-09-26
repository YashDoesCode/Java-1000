
import java.util.*;
public class MinWindowSubstring {

    public String minWindow(String s, String t) { Map<Character, Integer> mp = new HashMap<>();
        for (char c : t.toCharArray()) mp.put(c, mp.getOrDefault(c, 0) + 1);
        int cnt = mp.size(), l = 0, r = 0, minLen = Integer.MAX_VALUE, start = 0;
        while (r < s.length()) { char c = s.charAt(r);
            if (mp.containsKey(c)) { mp.put(c, mp.get(c) - 1);
                if (mp.get(c) == 0) cnt--;
            } r++;
            while (cnt == 0) { if (r - l < minLen) { minLen = r - l;
                    start = l;
                } char temp = s.charAt(l);
                if (mp.containsKey(temp)) { mp.put(temp, mp.get(temp) + 1);
                    if (mp.get(temp) > 0) cnt++;
                } l++;
            } } return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    };
}
