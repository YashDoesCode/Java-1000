public class SolvingQuestionsBrainpowerTopicDP {

    public long mostPoints(int[][] questions) { int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1;
        i >= 0;
        i--) { int pts = questions[i][0], bp = questions[i][1];
            int nxt = i + bp + 1;
            long take = pts + (nxt < n ? dp[nxt] : 0);
            long skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        } return dp[0];
    };
}
