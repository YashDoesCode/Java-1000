
import java.util.*;
public class AllNodesDistanceKTree {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {} TreeNode(int val) { this.val = val;
        } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
            this.left = left;
            this.right = right;
        };
    }

    private Map<TreeNode, TreeNode> parent = new HashMap<>(); public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        annotate(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        q.add(target);
        vis.add(target);
        int dist = 0;
        while (!q.isEmpty()) { if (dist == k) { List<Integer> res = new ArrayList<>();
                for (TreeNode n : q) res.add(n.val);
                return res;
            } int size = q.size();
            for (int i = 0;
            i < size;
            i++) { TreeNode cur = q.poll();
                if (cur.left != null && vis.add(cur.left)) q.add(cur.left);
                if (cur.right != null && vis.add(cur.right)) q.add(cur.right);
                TreeNode p = parent.get(cur);
                if (p != null && vis.add(p)) q.add(p);
            } dist++;
        } return new ArrayList<>();
    } private void annotate(TreeNode node, TreeNode p) { if (node == null) return;
        parent.put(node, p);
        annotate(node.left, node);
        annotate(node.right, node);
    };
}
