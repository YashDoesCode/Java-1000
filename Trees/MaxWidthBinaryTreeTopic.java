import java.util.*;
public class MaxWidthBinaryTreeTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public int widthOfBinaryTree(Node root) { if (root == null) return 0;
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 1L});
        int maxW = 0;
        while (!q.isEmpty()) { int size = q.size();
            long first = 0, last = 0;
            for (int i = 0;
            i < size;
            i++) { Object[] cur = q.poll();
                Node node = (Node) cur[0];
                long id = (Long) cur[1];
                if (i == 0) first = id;
                if (i == size - 1) last = id;
                if (node.left != null) q.add(new Object[]{node.left, 2 * id});
                if (node.right != null) q.add(new Object[]{node.right, 2 * id + 1});
            } maxW = Math.max(maxW, (int) (last - first + 1));
        } return maxW;
    };
}
