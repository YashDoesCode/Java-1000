
public class JumpGameII {

    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, maxV = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxV = Math.max(maxV, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = maxV;
            }
        }
        return jumps;
    }
}
