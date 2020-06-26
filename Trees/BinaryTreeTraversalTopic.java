import java.util.*;
public class BinaryTreeTraversalTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public List<Integer> inorder(Node root) { List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    } private void dfs(Node n, List<Integer> res) { if (n == null) return;
        dfs(n.left, res);
        res.add(n.val);
        dfs(n.right, res);
    };
}
