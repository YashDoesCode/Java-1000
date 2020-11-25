
public class MaxSubarray {

    public int maxSubArray(int[] nums) {
        int cur = nums[0], maxV = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            maxV = Math.max(maxV, cur);
        }
        return maxV;
    }
}
