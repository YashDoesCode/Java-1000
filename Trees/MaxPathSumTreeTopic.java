public class MaxPathSumTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(Node root) { helper(root);
        return maxSum;
    } private int helper(Node n) { if (n == null) return 0;
        int left = Math.max(0, helper(n.left)), right = Math.max(0, helper(n.right));
        maxSum = Math.max(maxSum, left + right + n.val);
        return n.val + Math.max(left, right);
    };
}
