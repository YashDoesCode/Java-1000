
public class MinimumCostForTicketsDP {

    public int mincostTickets(int[] days, int[] costs) { int last = days[days.length - 1];
        boolean[] travel = new boolean[last + 1];
        for (int d : days) travel[d] = true;
        int[] dp = new int[last + 1];
        for (int i = 1;
        i <= last;
        i++) { if (!travel[i]) { dp[i] = dp[i - 1];
                continue;
            } int c1 = dp[i - 1] + costs[0];
            int c7 = dp[Math.max(0, i - 7)] + costs[1];
            int c30 = dp[Math.max(0, i - 30)] + costs[2];
            dp[i] = Math.min(c1, Math.min(c7, c30));
        } return dp[last];
    };
}
