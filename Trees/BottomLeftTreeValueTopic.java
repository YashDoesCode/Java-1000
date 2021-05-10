import java.util.*;
public class BottomLeftTreeValueTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public int findBottomLeftValue(Node root) { Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node cur = null;
        while (!q.isEmpty()) { cur = q.poll();
            if (cur.right != null) q.add(cur.right);
            if (cur.left != null) q.add(cur.left);
        } return cur.val;
    };
}
