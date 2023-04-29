public class LowestCommonAncestorBSTTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public Node lca(Node root, Node p, Node q) { if (p.val < root.val && q.val < root.val) return lca(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lca(root.right, p, q);
        return root;
    };
}
