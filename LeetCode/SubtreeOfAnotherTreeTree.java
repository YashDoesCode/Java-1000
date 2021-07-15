
public class SubtreeOfAnotherTreeTree {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    } private boolean isSame(TreeNode a, TreeNode b) { if (a == null || b == null) return a == b;
        return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
    };
}
