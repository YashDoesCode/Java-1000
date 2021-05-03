import java.util.*;

public class CountSmallerNumbersSelf {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] res = new Integer[n];
        List<Integer> sorted = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            res[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }

    private int findIndex(List<Integer> sorted, int target) {
        int l = 0, r = sorted.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (sorted.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
