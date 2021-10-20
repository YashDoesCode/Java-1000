/*
 * Popular Question: Serialize and Deserialize Binary Tree
 * Source: LeetCode #297 (Hard)
 *
 * Problem Statement:
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTreeTopic {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static final String NULL_MARKER = "#";
    private static final String DELIMITER = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_MARKER).append(DELIMITER);
            return;
        }
        sb.append(node.val).append(DELIMITER);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        Queue<String> nodesQueue = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return buildTree(nodesQueue);
    }

    private TreeNode buildTree(Queue<String> nodesQueue) {
        String val = nodesQueue.poll();
        if (val == null || val.equals(NULL_MARKER)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodesQueue);
        node.right = buildTree(nodesQueue);
        return node;
    }

    public static void main(String[] args) {
        SerializeDeserializeTreeTopic codec = new SerializeDeserializeTreeTopic();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serializedStr = codec.serialize(root);
        System.out.println("Serialized Binary Tree String: " + serializedStr);

        TreeNode deserializedRoot = codec.deserialize(serializedStr);
        String reserializedStr = codec.serialize(deserializedRoot);
        System.out.println("Re-serialized Tree String: " + reserializedStr);
        System.out.println("Match: " + serializedStr.equals(reserializedStr));
    }
}
