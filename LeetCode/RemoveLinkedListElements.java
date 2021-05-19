
public class RemoveLinkedListElements {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null) { if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        } return dummy.next;
    };
}
