
public class LinkedListCycleII {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { ListNode p = head;
                while (p != slow) { p = p.next;
                    slow = slow.next;
                } return p;
            } } return null;
    };
}
