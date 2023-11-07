
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) { int maxV = 0, cur = 0;
        for (int x : nums) { if (x == 1) { cur++;
                maxV = Math.max(maxV, cur);
            } else cur = 0;
        } return maxV;
    };
}
