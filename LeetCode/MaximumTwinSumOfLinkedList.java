
public class MaximumTwinSumOfLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
        } ListNode prev = null, cur = slow;
        while (cur != null) { ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } int maxV = 0;
        ListNode p1 = head, p2 = prev;
        while (p2 != null) { maxV = Math.max(maxV, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        } return maxV;
    };
}
