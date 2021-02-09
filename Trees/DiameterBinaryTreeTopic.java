public class DiameterBinaryTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } private int maxD = 0;

    public int diameter(Node root) { depth(root);
        return maxD;
    } private int depth(Node n) { if (n == null) return 0;
        int l = depth(n.left), r = depth(n.right);
        maxD = Math.max(maxD, l + r);
        return 1 + Math.max(l, r);
    };
}
