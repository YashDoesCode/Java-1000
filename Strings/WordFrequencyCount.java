import java.util.*;
public class WordFrequencyCount {

    public Map<String, Integer> countWords(String s) { Map<String, Integer> mp = new HashMap<>();
        for (String w : s.split("\\s+")) mp.put(w, mp.getOrDefault(w, 0) + 1);
        return mp;
    };
}
