
public class GreatestSumDivisibleByThreeDP {

    public int maxSumDivThree(int[] nums) { int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int x : nums) { int[] next = dp.clone();
            for (int i = 0;
            i < 3;
            i++) { if (dp[i] != Integer.MIN_VALUE) { int rem = (i + x) % 3;
                    next[rem] = Math.max(next[rem], dp[i] + x);
                } } dp = next;
        } return dp[0];
    };
}
