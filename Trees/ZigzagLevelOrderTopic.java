import java.util.*;
public class ZigzagLevelOrderTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public List<List<Integer>> zigzag(Node root) { List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean rev = false;
        while (!q.isEmpty()) { int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0;
            i < size;
            i++) { Node cur = q.poll();
                if (rev) level.addFirst(cur.val);
                else level.addLast(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            } res.add(level);
            rev = !rev;
        } return res;
    };
}
