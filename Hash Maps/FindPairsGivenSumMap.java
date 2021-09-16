import java.util.*;
public class FindPairsGivenSumMap {

    private int[] n1, n2;

    private Map<Integer, Integer> mp = new HashMap<>();

    public FindPairsGivenSumMap(int[] nums1, int[] nums2) { n1 = nums1;
        n2 = nums2;
        for (int v : n2) mp.put(v, mp.getOrDefault(v, 0) + 1);
    } public void add(int index, int val) { mp.put(n2[index], mp.get(n2[index]) - 1);
        n2[index] += val;
        mp.put(n2[index], mp.getOrDefault(n2[index], 0) + 1);
    } public int count(int tot) { int ans = 0;
        for (int v : n1) ans += mp.getOrDefault(tot - v, 0);
        return ans;
    };
}
