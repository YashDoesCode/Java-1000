
import java.util.*;
public class HouseRobberIIITree {

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

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    } private int[] dfs(TreeNode node) { if (node == null) return new int[2];
        int[] l = dfs(node.left), r = dfs(node.right);
        int[] res = new int[2];
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = node.val + l[0] + r[0];
        return res;
    };
}
