public class PathSumTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public boolean hasPathSum(Node root, int target) { if (root == null) return false;
        if (root.left == null && root.right == null) return target == root.val;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    };
}
