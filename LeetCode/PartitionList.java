
public class PartitionList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode partition(ListNode head, int x) {
        ListNode bHead = new ListNode(0), sHead = new ListNode(0);
        ListNode b = bHead, s = sHead;
        while (head != null) { if (head.val < x) { s.next = head;
                s = s.next;
            } else { b.next = head;
                b = b.next;
            } head = head.next;
        } b.next = null;
        s.next = bHead.next;
        return sHead.next;
    };
}
