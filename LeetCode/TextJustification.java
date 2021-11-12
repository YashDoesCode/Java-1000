
import java.util.*;
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) { List<String> res = new ArrayList<>();
        int idx = 0;
        while (idx < words.length) { int count = words[idx].length(), last = idx + 1;
            while (last < words.length) { if (words[last].length() + 1 + count > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            } StringBuilder sb = new StringBuilder();
            int diff = last - idx - 1;
            if (last == words.length || diff == 0) { for (int i = idx;
                i < last;
                i++) { sb.append(words[i]).append(" ");
                } sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) sb.append(" ");
            } else { int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = idx;
                i < last;
                i++) { sb.append(words[i]);
                    if (i < last - 1) { for (int j = 0;
                        j <= (spaces + (i - idx < r ? 1 : 0));
                        j++) sb.append(" ");
                    } } } res.add(sb.toString());
            idx = last;
        } return res;
    };
}
