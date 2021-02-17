public class SortedArrayToBSTTopic {

    class Node { int val;

        Node left, right;
        Node(int v) { val = v;
        } } public Node sortedArrayToBST(int[] nums) { return build(nums, 0, nums.length - 1);
    } private Node build(int[] nums, int l, int r) { if (l > r) return null;
        int mid = l + (r - l) / 2;
        Node root = new Node(nums[mid]);
        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);
        return root;
    };
}
