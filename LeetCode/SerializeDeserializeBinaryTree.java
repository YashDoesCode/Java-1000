import java.util.*;

public class SerializeDeserializeBinaryTree {

    public static class TreeNode {

        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }

    public String serialize(TreeNode root) {
        if (root == null) return "X";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}
