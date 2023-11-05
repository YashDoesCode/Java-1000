
import java.util.*;
public class MinDeletionsUniqueFreq {

    public int minDeletions(String s) { int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        Set<Integer> used = new HashSet<>();
        int del = 0;
        for (int f : cnt) { while (f > 0 && !used.add(f)) { f--;
                del++;
            } } return del;
    };
}
