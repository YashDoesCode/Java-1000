
public class SortListLL {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
        } ListNode mid = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head), l2 = sortList(mid);
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) { if (l1.val < l2.val) { cur.next = l1;
                l1 = l1.next;
            } else { cur.next = l2;
                l2 = l2.next;
            } cur = cur.next;
        } cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    };
}
