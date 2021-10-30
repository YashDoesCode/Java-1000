import java.util.*;
public class ConstructTreePostInTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } private Map<Integer, Integer> mp = new HashMap<>();

    private int postIdx;

    public Node buildTree(int[] inorder, int[] postorder) { postIdx = postorder.length - 1;
        for (int i = 0;
        i < inorder.length;
        i++) mp.put(inorder[i], i);
        return build(postorder, 0, inorder.length - 1);
    } private Node build(int[] post, int inL, int inR) { if (inL > inR) return null;
        int val = post[postIdx--];
        Node root = new Node(val);
        int idx = mp.get(val);
        root.right = build(post, idx + 1, inR);
        root.left = build(post, inL, idx - 1);
        return root;
    };
}
