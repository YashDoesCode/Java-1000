
import java.util.*;
public class ConstructTreePostInTree {

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

    private Map<Integer, Integer> mp = new HashMap<>(); private int postIdx; public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        for (int i = 0;
        i < inorder.length;
        i++) mp.put(inorder[i], i);
        return build(postorder, 0, inorder.length - 1);
    } private TreeNode build(int[] post, int inL, int inR) { if (inL > inR) return null;
        int val = post[postIdx--];
        TreeNode root = new TreeNode(val);
        int idx = mp.get(val);
        root.right = build(post, idx + 1, inR);
        root.left = build(post, inL, idx - 1);
        return root;
    };
}
