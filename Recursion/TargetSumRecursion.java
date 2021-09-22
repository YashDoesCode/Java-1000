public class TargetSumRecursion {

    public int findTargetSumWays(int[] nums, int target) { return dfs(nums, 0, 0, target);
    } private int dfs(int[] nums, int idx, int curSum, int target) { if (idx == nums.length) return curSum == target ? 1 : 0;
        return dfs(nums, idx + 1, curSum + nums[idx], target) + dfs(nums, idx + 1, curSum - nums[idx], target);
    };
}
