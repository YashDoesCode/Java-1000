public class PartitionEqualSubsetRecursion {

    public boolean canPartition(int[] nums) { int sum = 0;
        for (int x : nums) sum += x;
        if (sum % 2 != 0) return false;
        return dfs(nums, 0, sum / 2);
    } private boolean dfs(int[] nums, int idx, int target) { if (target == 0) return true;
        if (idx >= nums.length || target < 0) return false;
        return dfs(nums, idx + 1, target - nums[idx]) || dfs(nums, idx + 1, target);
    };
}
