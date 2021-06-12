
import java.util.*;
public class KthSmallestElementInBSTTree {

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

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) { while (cur != null) { st.push(cur);
                cur = cur.left;
            } cur = st.pop();
            if (--k == 0) return cur.val;
            cur = cur.right;
        } return -1;
    };
}
