public class BinarySearchTreeOps {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } private Node root;

    public void insert(int val) { root = insertRec(root, val);
    } private Node insertRec(Node n, int v) { if (n == null) return new Node(v);
        if (v < n.val) n.left = insertRec(n.left, v);
        else n.right = insertRec(n.right, v);
        return n;
    };
}
