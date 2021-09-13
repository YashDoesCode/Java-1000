
public class PopulatingNextRightPointersTree {

    class Node { int val;

        Node left;
        Node right;
        Node next;
        Node() {} Node(int val) { this.val = val;
        } } public Node connect(Node root) { if (root == null) return null;
        if (root.left != null) { root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        } connect(root.left);
        connect(root.right);
        return root;
    };
}
