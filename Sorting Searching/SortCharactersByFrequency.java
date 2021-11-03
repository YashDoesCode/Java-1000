import java.util.*;
public class SortCharactersByFrequency {

    public String frequencySort(String s) { Map<Character, Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()) mp.put(c, mp.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(mp.get(b), mp.get(a)));
        pq.addAll(mp.keySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) { char c = pq.poll();
            int cnt = mp.get(c);
            for (int i = 0;
            i < cnt;
            i++) sb.append(c);
        } return sb.toString();
    };
}
