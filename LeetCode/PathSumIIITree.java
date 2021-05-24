
import java.util.*;
public class PathSumIIITree {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {} TreeNode(int val) { this.val = val;
        } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
            this.left = left;
            this.right = right;
        };
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0L, 1);
        return dfs(root, 0L, targetSum, mp);
    } private int dfs(TreeNode node, long curSum, int target, Map<Long, Integer> mp) { if (node == null) return 0;
        curSum += node.val;
        int res = mp.getOrDefault(curSum - target, 0);
        mp.put(curSum, mp.getOrDefault(curSum, 0) + 1);
        res += dfs(node.left, curSum, target, mp) + dfs(node.right, curSum, target, mp);
        mp.put(curSum, mp.get(curSum) - 1);
        return res;
    };
}
