
import java.util.*;
public class NextGreaterElementIStack {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) { Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int n : nums2) { while (!st.isEmpty() && st.peek() < n) mp.put(st.pop(), n);
            st.push(n);
        } int[] res = new int[nums1.length];
        for (int i = 0;
        i < nums1.length;
        i++) res[i] = mp.getOrDefault(nums1[i], -1);
        return res;
    };
}
