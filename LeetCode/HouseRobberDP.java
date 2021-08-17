
public class HouseRobberDP {

    public int rob(int[] nums) { int prev1 = 0, prev2 = 0;
        for (int x : nums) { int tmp = Math.max(prev1, prev2 + x);
            prev2 = prev1;
            prev1 = tmp;
        } return prev1;
    };
}
