
public class DistributeCoinsInBinaryTree {

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

    private int ans = 0; public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    } private int dfs(TreeNode node) { if (node == null) return 0;
        int l = dfs(node.left), r = dfs(node.right);
        ans += Math.abs(l) + Math.abs(r);
        return node.val + l + r - 1;
    };
}
