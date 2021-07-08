import java.util.*;
public class CharacterFrequencyParser {

    public Map<Character, Integer> parse(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        if (text == null) return freq;
        for (char c : text.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        return freq;
    }
}
