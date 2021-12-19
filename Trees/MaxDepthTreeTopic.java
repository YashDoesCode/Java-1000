public class MaxDepthTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public int maxDepth(Node root) { if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    };
}
