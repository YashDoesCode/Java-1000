import java.util.*;
public class LevelOrderTraversalTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public List<List<Integer>> levelOrder(Node root) { List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) { int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0;
            i < size;
            i++) { Node cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            } res.add(level);
        } return res;
    };
}
