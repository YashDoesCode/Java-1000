public class RedBlackTreeOps {

    private static final boolean RED = true, BLACK = false;
    class Node { int key;

        Node left, right;
        boolean color;
        Node(int k, boolean c) { key = k;
            color = c;
        } } private boolean isRed(Node x) { return x != null && x.color == RED;
    };
}
