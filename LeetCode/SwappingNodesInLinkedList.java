
public class SwappingNodesInLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null, n2 = null, cur = head;
        int len = 0;
        while (cur != null) { len++;
            if (n2 != null) n2 = n2.next;
            if (len == k) { n1 = cur;
                n2 = head;
            } cur = cur.next;
        } int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
        return head;
    };
}
