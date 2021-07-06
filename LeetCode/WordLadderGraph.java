
import java.util.*;
public class WordLadderGraph {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) { Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len = 1;
        while (!q.isEmpty()) { int size = q.size();
            for (int i = 0;
            i < size;
            i++) { String cur = q.poll();
                if (cur.equals(endWord)) return len;
                char[] ch = cur.toCharArray();
                for (int j = 0;
                j < ch.length;
                j++) { char old = ch[j];
                    for (char c = 'a';
                    c <= 'z';
                    c++) { ch[j] = c;
                        String nxt = new String(ch);
                        if (set.contains(nxt)) { q.add(nxt);
                            set.remove(nxt);
                        } } ch[j] = old;
                } } len++;
        } return 0;
    };
}
