
import java.util.*;
public class FindBottomLeftTreeValueTree {

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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode cur = null;
        while (!q.isEmpty()) { cur = q.poll();
            if (cur.right != null) q.add(cur.right);
            if (cur.left != null) q.add(cur.left);
        } return cur.val;
    };
}
