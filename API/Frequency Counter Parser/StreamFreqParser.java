import java.util.*;

public class StreamFreqParser {

    private final Map<String, Integer> freqMap = new HashMap<>();

    public void parseStream(String text) {
        if (text == null || text.isEmpty()) return;
        String[] tokens = text.toLowerCase().split("\\W+");
        for (String t : tokens) {
            if (!t.isEmpty()) {
                freqMap.put(t, freqMap.getOrDefault(t, 0) + 1);
            }
        }
    }

    public List<Map.Entry<String, Integer>> getTopK(int k) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Map.Entry<String, Integer>> res = new ArrayList<>(pq);
        res.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return res;
    }

    public int getCount(String word) {
        return freqMap.getOrDefault(word.toLowerCase(), 0);
    }
}
