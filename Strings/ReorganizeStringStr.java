import java.util.*;
public class ReorganizeStringStr {

    public String reorganizeString(String s) { int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0;
        i < 26;
        i++) if (cnt[i] > 0) pq.add(new int[]{i, cnt[i]});
        StringBuilder sb = new StringBuilder();
        int[] prev = new int[]{-1, 0};
        while (!pq.isEmpty()) { int[] cur = pq.poll();
            if (prev[1] > 0) pq.add(prev);
            sb.append((char) (cur[0] + 'a'));
            cur[1]--;
            prev = cur;
        } return sb.length() == s.length() ? sb.toString() : "";
    };
}
