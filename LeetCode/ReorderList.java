
public class ReorderList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) { slow = slow.next;
            fast = fast.next.next;
        } ListNode prev = null, cur = slow.next;
        slow.next = null;
        while (cur != null) { ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } ListNode p1 = head, p2 = prev;
        while (p2 != null) { ListNode t1 = p1.next, t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        } };
}
