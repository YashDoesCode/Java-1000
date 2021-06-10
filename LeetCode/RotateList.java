
public class RotateList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) { cur = cur.next;
            len++;
        } cur.next = head;
        k = len - k % len;
        for (int i = 0;
        i < k;
        i++) cur = cur.next;
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    };
}
