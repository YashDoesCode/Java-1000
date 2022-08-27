
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxV = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxV) return false;
            maxV = Math.max(maxV, i + nums[i]);
        }
        return true;
    }
}
