
public class RemoveNthNodeFromEnd {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), p1 = dummy, p2 = dummy;
        for (int i = 0;
        i <= n;
        i++) p1 = p1.next;
        while (p1 != null) { p1 = p1.next;
            p2 = p2.next;
        } p2.next = p2.next.next;
        return dummy.next;
    };
}
