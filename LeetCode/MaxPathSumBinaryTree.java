
public class MaxPathSumBinaryTree {

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

    private int maxSum = Integer.MIN_VALUE; public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    } private int helper(TreeNode node) { if (node == null) return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    };
}
