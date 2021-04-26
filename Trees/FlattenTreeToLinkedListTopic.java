public class FlattenTreeToLinkedListTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } private Node prev = null;

    public void flatten(Node root) { if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    };
}
