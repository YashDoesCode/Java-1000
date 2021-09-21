
import java.util.*;
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) { Map<Integer, Integer> losses = new TreeMap<>();
        for (int[] m : matches) { losses.putIfAbsent(m[0], 0);
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        } List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int player : losses.keySet()) { int l = losses.get(player);
            if (l == 0) ans.get(0).add(player);
            else if (l == 1) ans.get(1).add(player);
        } return ans;
    };
}
