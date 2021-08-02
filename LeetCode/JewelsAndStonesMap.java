
import java.util.*;
public class JewelsAndStonesMap {

    public int numJewelsInStones(String jewels, String stones) { Set<Character> s = new HashSet<>();
        for (char c : jewels.toCharArray()) s.add(c);
        int ans = 0;
        for (char c : stones.toCharArray()) if (s.contains(c)) ans++;
        return ans;
    };
}
