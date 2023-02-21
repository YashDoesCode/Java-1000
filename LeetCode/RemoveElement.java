
public class RemoveElement {

    public int removeElement(int[] nums, int val) { int idx = 0;
        for (int x : nums) if (x != val) nums[idx++] = x;
        return idx;
    };
}
