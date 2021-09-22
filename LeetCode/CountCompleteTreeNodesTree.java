
public class CountCompleteTreeNodesTree {

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

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = leftHeight(root.left), r = rightHeight(root.right);
        if (l == r) return (1 << (l + 1)) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    } private int leftHeight(TreeNode node) { return node == null ? 0 : 1 + leftHeight(node.left);
    } private int rightHeight(TreeNode node) { return node == null ? 0 : 1 + rightHeight(node.right);
    };
}
