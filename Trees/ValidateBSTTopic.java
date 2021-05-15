public class ValidateBSTTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public boolean isValidBST(Node root) { return validate(root, null, null);
    } private boolean validate(Node n, Integer min, Integer max) { if (n == null) return true;
        if ((min != null && n.val <= min) || (max != null && n.val >= max)) return false;
        return validate(n.left, min, n.val) && validate(n.right, n.val, max);
    };
}
