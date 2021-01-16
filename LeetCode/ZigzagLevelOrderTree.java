
import java.util.*;
public class ZigzagLevelOrderTree {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean rev = false;
        while (!q.isEmpty()) { int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0;
            i < size;
            i++) { TreeNode cur = q.poll();
                if (rev) level.addFirst(cur.val);
                else level.addLast(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            } res.add(level);
            rev = !rev;
        } return res;
    };
}
