
public class RemoveDuplicatesFromSortedListII {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), prev = dummy, cur = head;
        while (cur != null) { while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            if (prev.next == cur) prev = prev.next;
            else prev.next = cur.next;
            cur = cur.next;
        } return dummy.next;
    };
}
