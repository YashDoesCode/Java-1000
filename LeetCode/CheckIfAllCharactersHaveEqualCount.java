
import java.util.*;
public class CheckIfAllCharactersHaveEqualCount {

    public boolean areOccurrencesEqual(String s) { int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        int val = 0;
        for (int c : cnt) { if (c > 0) { if (val == 0) val = c;
                else if (val != c) return false;
            } } return true;
    };
}
