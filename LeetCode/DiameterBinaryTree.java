
public class DiameterBinaryTree {

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

    private int maxD = 0; public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxD;
    } private int depth(TreeNode node) { if (node == null) return 0;
        int l = depth(node.left), r = depth(node.right);
        maxD = Math.max(maxD, l + r);
        return 1 + Math.max(l, r);
    };
}
