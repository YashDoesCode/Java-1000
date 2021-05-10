public class LowestCommonAncestorBTTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public Node lca(Node root, Node p, Node q) { if (root == null || root == p || root == q) return root;
        Node l = lca(root.left, p, q), r = lca(root.right, p, q);
        return (l != null && r != null) ? root : (l != null ? l : r);
    };
}
