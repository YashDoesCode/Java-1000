
import java.util.*;
public class PostorderTraversalTree {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) { TreeNode node = st.pop();
            res.addFirst(node.val);
            if (node.left != null) st.push(node.left);
            if (node.right != null) st.push(node.right);
        } return res;
    };
}
