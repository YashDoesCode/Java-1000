
import java.util.*;
public class CheckIfSentenceIsPangramMap {

    public boolean checkIfPangram(String sentence) { Set<Character> s = new HashSet<>();
        for (char c : sentence.toCharArray()) s.add(c);
        return s.size() == 26;
    };
}
