import java.util.*;
public class MatchsticksToSquareRecursion {

    public boolean makesquare(int[] matchsticks) { int sum = 0;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        return dfs(matchsticks, matchsticks.length - 1, sides, sum / 4);
    } private boolean dfs(int[] m, int idx, int[] sides, int target) { if (idx < 0) return sides[0] == target && sides[1] == target && sides[2] == target;
        for (int i = 0;
        i < 4;
        i++) { if (sides[i] + m[idx] <= target) { sides[i] += m[idx];
                if (dfs(m, idx - 1, sides, target)) return true;
                sides[i] -= m[idx];
            } } return false;
    };
}
