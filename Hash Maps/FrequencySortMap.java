import java.util.*;
public class FrequencySortMap {

    public int[] frequencySort(int[] nums) { Map<Integer, Integer> mp = new HashMap<>();
        for (int n : nums) mp.put(n, mp.getOrDefault(n, 0) + 1);
        Integer[] a = new Integer[nums.length];
        for (int i = 0;
        i < nums.length;
        i++) a[i] = nums[i];
        Arrays.sort(a, (x, y) -> !mp.get(x).equals(mp.get(y)) ? Integer.compare(mp.get(x), mp.get(y)) : Integer.compare(y, x));
        for (int i = 0;
        i < nums.length;
        i++) nums[i] = a[i];
        return nums;
    };
}
