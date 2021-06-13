public class InvertBinaryTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public Node invertTree(Node root) { if (root == null) return null;
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    };
}
