
public class MoveZeroes {

    public void moveZeroes(int[] nums) { int idx = 0;
        for (int x : nums) if (x != 0) nums[idx++] = x;
        while (idx < nums.length) nums[idx++] = 0;
    };
}
