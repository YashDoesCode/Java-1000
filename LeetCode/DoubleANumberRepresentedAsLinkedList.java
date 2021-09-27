
public class DoubleANumberRepresentedAsLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode doubleIt(ListNode head) {
        if (head.val >= 5) head = new ListNode(0, head);
        for (ListNode cur = head;
        cur != null;
        cur = cur.next) { cur.val = (cur.val * 2) % 10;
            if (cur.next != null && cur.next.val >= 5) cur.val++;
        } return head;
    };
}
