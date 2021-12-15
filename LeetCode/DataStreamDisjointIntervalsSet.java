import java.util.*;

public class DataStreamDisjointIntervalsSet {

    private final TreeMap<Integer, int[]> treeMap = new TreeMap<>();

    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer l = treeMap.lowerKey(val);
        Integer h = treeMap.higherKey(val);
        if (l != null && h != null && treeMap.get(l)[1] + 1 == val && val + 1 == treeMap.get(h)[0]) {
            treeMap.get(l)[1] = treeMap.get(h)[1];
            treeMap.remove(h);
        } else if (l != null && treeMap.get(l)[1] + 1 >= val) {
            treeMap.get(l)[1] = Math.max(treeMap.get(l)[1], val);
        } else if (h != null && val + 1 == treeMap.get(h)[0]) {
            treeMap.put(val, new int[]{val, treeMap.get(h)[1]});
            treeMap.remove(h);
        } else {
            treeMap.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>(treeMap.values());
        return res.toArray(new int[res.size()][]);
    }
}
