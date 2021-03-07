
import java.util.*;
public class IntersectionTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) { Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums1) mp.put(x, mp.getOrDefault(x, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (int x : nums2) { if (mp.getOrDefault(x, 0) > 0) { list.add(x);
                mp.put(x, mp.get(x) - 1);
            } } int[] res = new int[list.size()];
        for (int i = 0;
        i < list.size();
        i++) res[i] = list.get(i);
        return res;
    };
}
