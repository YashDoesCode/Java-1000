public class SumRootToLeafNumbersTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public int sumNumbers(Node root) { return dfs(root, 0);
    } private int dfs(Node n, int sum) { if (n == null) return 0;
        sum = sum * 10 + n.val;
        if (n.left == null && n.right == null) return sum;
        return dfs(n.left, sum) + dfs(n.right, sum);
    };
}
