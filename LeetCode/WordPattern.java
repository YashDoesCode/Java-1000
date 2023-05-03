
import java.util.*;
public class WordPattern {

    public boolean wordPattern(String pattern, String s) { String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> mp = new HashMap<>();
        for (int i = 0;
        i < pattern.length();
        i++) { char c = pattern.charAt(i);
            if (mp.containsKey(c)) { if (!mp.get(c).equals(words[i])) return false;
            } else { if (mp.containsValue(words[i])) return false;
                mp.put(c, words[i]);
            } } return true;
    };
}
