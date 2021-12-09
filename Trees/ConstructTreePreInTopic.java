import java.util.*;
public class ConstructTreePreInTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } private Map<Integer, Integer> mp = new HashMap<>();

    private int preIdx = 0;

    public Node buildTree(int[] preorder, int[] inorder) { for (int i = 0;
        i < inorder.length;
        i++) mp.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    } private Node build(int[] pre, int inL, int inR) { if (inL > inR) return null;
        int val = pre[preIdx++];
        Node root = new Node(val);
        int idx = mp.get(val);
        root.left = build(pre, inL, idx - 1);
        root.right = build(pre, idx + 1, inR);
        return root;
    };
}
