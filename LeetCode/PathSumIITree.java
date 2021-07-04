
import java.util.*;
public class PathSumIITree {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    } private void dfs(TreeNode node, int sum, List<Integer> cur, List<List<Integer>> res) { if (node == null) return;
        cur.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) res.add(new ArrayList<>(cur));
        dfs(node.left, sum - node.val, cur, res);
        dfs(node.right, sum - node.val, cur, res);
        cur.remove(cur.size() - 1);
    };
}
