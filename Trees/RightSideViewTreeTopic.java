import java.util.*;
public class RightSideViewTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public List<Integer> rightSideView(Node root) { List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) { int size = q.size();
            for (int i = 0;
            i < size;
            i++) { Node cur = q.poll();
                if (i == size - 1) res.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            } } return res;
    };
}
