public class CountCompleteTreeNodesTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public int countNodes(Node root) { if (root == null) return 0;
        int l = leftHeight(root.left), r = rightHeight(root.right);
        if (l == r) return (1 << (l + 1)) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    } private int leftHeight(Node n) { return n == null ? 0 : 1 + leftHeight(n.left);
    } private int rightHeight(Node n) { return n == null ? 0 : 1 + rightHeight(n.right);
    };
}
