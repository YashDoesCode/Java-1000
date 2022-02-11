import java.util.*;
public class KthSmallestElement1D {

    public int kthSmallest(int[] a, int k) { PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int x : a) { pq.add(x);
            if (pq.size() > k) pq.poll();
        } return pq.peek();
    };
}
