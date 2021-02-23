import java.util.*;
public class PathSumIITopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public List<List<Integer>> pathSum(Node root, int target) { List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, new ArrayList<>(), res);
        return res;
    } private void dfs(Node n, int sum, List<Integer> cur, List<List<Integer>> res) { if (n == null) return;
        cur.add(n.val);
        if (n.left == null && n.right == null && sum == n.val) res.add(new ArrayList<>(cur));
        dfs(n.left, sum - n.val, cur, res);
        dfs(n.right, sum - n.val, cur, res);
        cur.remove(cur.size() - 1);
    };
}
