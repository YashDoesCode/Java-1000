public class SubtreeOfAnotherTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public boolean isSubtree(Node root, Node sub) { if (root == null) return false;
        if (isSame(root, sub)) return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    } private boolean isSame(Node a, Node b) { if (a == null || b == null) return a == b;
        return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
    };
}
