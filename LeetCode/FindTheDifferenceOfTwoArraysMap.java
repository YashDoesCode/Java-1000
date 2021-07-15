
import java.util.*;
public class FindTheDifferenceOfTwoArraysMap {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) { Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int n : nums1) s1.add(n);
        for (int n : nums2) s2.add(n);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int n : s1) if (!s2.contains(n)) ans.get(0).add(n);
        for (int n : s2) if (!s1.contains(n)) ans.get(1).add(n);
        return ans;
    };
}
