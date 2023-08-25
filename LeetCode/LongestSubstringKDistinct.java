
import java.util.*;
public class LongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) { if (k == 0) return 0;
        Map<Character, Integer> mp = new HashMap<>();
        int maxV = 0, l = 0;
        for (int r = 0;
        r < s.length();
        r++) { char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            while (mp.size() > k) { char temp = s.charAt(l);
                mp.put(temp, mp.get(temp) - 1);
                if (mp.get(temp) == 0) mp.remove(temp);
                l++;
            } maxV = Math.max(maxV, r - l + 1);
        } return maxV;
    };
}
