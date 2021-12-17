import java.util.*;
public class KthSmallestBSTTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public int kthSmallest(Node root, int k) { Stack<Node> st = new Stack<>();
        Node cur = root;
        while (cur != null || !st.isEmpty()) { while (cur != null) { st.push(cur);
                cur = cur.left;
            } cur = st.pop();
            if (--k == 0) return cur.val;
            cur = cur.right;
        } return -1;
    };
}
