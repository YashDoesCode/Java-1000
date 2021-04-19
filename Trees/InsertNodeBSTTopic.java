public class InsertNodeBSTTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public Node insertIntoBST(Node root, int val) { if (root == null) return new Node(val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    };
}
