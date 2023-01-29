
import java.util.*;
public class ConstructTreePreIn {

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

    private Map<Integer, Integer> mp = new HashMap<>(); private int preIdx = 0; public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0;
        i < inorder.length;
        i++) mp.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    } private TreeNode build(int[] pre, int inL, int inR) { if (inL > inR) return null;
        int val = pre[preIdx++];
        TreeNode root = new TreeNode(val);
        int idx = mp.get(val);
        root.left = build(pre, inL, idx - 1);
        root.right = build(pre, idx + 1, inR);
        return root;
    };
}
