import java.util.*;
public class IntersectionTwoArraysSearch {

    public int[] intersection(int[] nums1, int[] nums2) { Set<Integer> s1 = new HashSet<>(), res = new HashSet<>();
        for (int x : nums1) s1.add(x);
        for (int x : nums2) if (s1.contains(x)) res.add(x);
        int[] a = new int[res.size()];
        int i = 0;
        for (int x : res) a[i++] = x;
        return a;
    };
}
