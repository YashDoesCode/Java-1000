import java.util.*;
public class WordFrequencyParser {

    public Map<String, Integer> parse(String text) {
        Map<String, Integer> freq = new HashMap<>();
        if (text == null || text.isEmpty()) return freq;
        String[] words = text.toLowerCase().split("\\W+");
        for (String w : words) if (!w.isEmpty()) freq.put(w, freq.getOrDefault(w, 0) + 1);
        return freq;
    }
}
