
import java.util.*;
public class PermutationsMath {

    public List<List<Integer>> permute(int[] nums) { List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res);
        return res;
    } private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> res) { if (cur.size() == nums.length) { res.add(new ArrayList<>(cur));
            return;
        } for (int n : nums) { if (cur.contains(n)) continue;
            cur.add(n);
            dfs(nums, cur, res);
            cur.remove(cur.size() - 1);
        } };
}
