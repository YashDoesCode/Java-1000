public class BalancedBinaryTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public boolean isBalanced(Node root) { return height(root) != -1;
    } private int height(Node n) { if (n == null) return 0;
        int l = height(n.left);
        if (l == -1) return -1;
        int r = height(n.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    };
}
