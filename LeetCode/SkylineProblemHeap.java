import java.util.*;

public class SkylineProblemHeap {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        heights.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        int prevMax = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int[] h : heights) {
            if (h[1] < 0) pq.add(-h[1]);
            else pq.remove(h[1]);
            int currMax = pq.peek();
            if (currMax != prevMax) {
                result.add(Arrays.asList(h[0], currMax));
                prevMax = currMax;
            }
        }
        return result;
    }
}
