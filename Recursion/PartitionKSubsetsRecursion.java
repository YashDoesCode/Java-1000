import java.util.*;
public class PartitionKSubsetsRecursion {

    public boolean canPartitionKSubsets(int[] nums, int k) { int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        int[] subset = new int[k];
        return dfs(nums, nums.length - 1, subset, sum / k);
    } private boolean dfs(int[] nums, int idx, int[] subset, int target) { if (idx < 0) return true;
        for (int i = 0;
        i < subset.length;
        i++) { if (subset[i] + nums[idx] <= target) { subset[i] += nums[idx];
                if (dfs(nums, idx - 1, subset, target)) return true;
                subset[i] -= nums[idx];
            } if (subset[i] == 0) break;
        } return false;
    };
}
