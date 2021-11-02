import java.util.*;
public class RemoveDuplicateChars {

    public String removeDuplicates(String s) { Set<Character> set = new LinkedHashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        StringBuilder sb = new StringBuilder();
        for (char c : set) sb.append(c);
        return sb.toString();
    };
}
