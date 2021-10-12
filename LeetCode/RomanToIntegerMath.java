
import java.util.*;
public class RomanToIntegerMath {

    public int romanToInt(String s) { Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        int ans = 0;
        for (int i = 0;
        i < s.length();
        i++) { int val = mp.get(s.charAt(i));
            if (i + 1 < s.length() && val < mp.get(s.charAt(i + 1))) ans -= val;
            else ans += val;
        } return ans;
    };
}
