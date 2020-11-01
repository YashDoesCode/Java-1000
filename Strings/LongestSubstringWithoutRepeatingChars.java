import java.util.*;
public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) { int maxV = 0, l = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (int r = 0;
        r < s.length();
        r++) { char c = s.charAt(r);
            if (mp.containsKey(c)) l = Math.max(l, mp.get(c) + 1);
            mp.put(c, r);
            maxV = Math.max(maxV, r - l + 1);
        } return maxV;
    };
}
