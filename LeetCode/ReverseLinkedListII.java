
public class ReverseLinkedListII {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head), prev = dummy;
        for (int i = 0;
        i < left - 1;
        i++) prev = prev.next;
        ListNode start = prev.next, then = start.next;
        for (int i = 0;
        i < right - left;
        i++) { start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        } return dummy.next;
    };
}
