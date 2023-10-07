
import java.util.*;
public class TopKFrequentElementsMap {

    public int[] topKFrequent(int[] nums, int k) { Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) count.put(n, count.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(count.get(a), count.get(b)));
        for (int n : count.keySet()) { heap.add(n);
            if (heap.size() > k) heap.poll();
        } int[] res = new int[k];
        for (int i = k - 1;
        i >= 0;
        i--) res[i] = heap.poll();
        return res;
    };
}
