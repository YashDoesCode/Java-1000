public class DeleteNodeBSTTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public Node deleteNode(Node root, int key) { if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else { if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } return root;
    } private Node findMin(Node n) { while (n.left != null) n = n.left;
        return n;
    };
}
