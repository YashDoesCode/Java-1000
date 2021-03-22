
public class LastStoneWeightIIDP {

    public int lastStoneWeightII(int[] stones) { int sum = 0;
        for (int s : stones) sum += s;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int s : stones) for (int i = sum / 2;
        i >= s;
        i--) dp[i] = dp[i] || dp[i - s];
        for (int i = sum / 2;
        i >= 0;
        i--) if (dp[i]) return sum - 2 * i;
        return 0;
    };
}
