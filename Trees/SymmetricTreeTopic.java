public class SymmetricTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public boolean isSymmetric(Node root) { return root == null || check(root.left, root.right);
    } private boolean check(Node n1, Node n2) { if (n1 == null || n2 == null) return n1 == n2;
        return n1.val == n2.val && check(n1.left, n2.right) && check(n1.right, n2.left);
    };
}
