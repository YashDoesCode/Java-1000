
public class HouseRobberIIDP {

    public int rob(int[] nums) { int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    } private int robRange(int[] a, int l, int r) { int prev1 = 0, prev2 = 0;
        for (int i = l;
        i <= r;
        i++) { int tmp = Math.max(prev1, prev2 + a[i]);
            prev2 = prev1;
            prev1 = tmp;
        } return prev1;
    };
}
