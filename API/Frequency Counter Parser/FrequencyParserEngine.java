import java.util.*;

public class FrequencyParserEngine {

    public Map<String, Integer> countWordFrequency(String content) {
        Map<String, Integer> map = new HashMap<>();
        if (content == null) return map;
        String[] words = content.split("\\s+");
        for (String w : words) {
            String clean = w.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!clean.isEmpty()) {
                map.put(clean, map.getOrDefault(clean, 0) + 1);
            }
        }
        return map;
    }
}
