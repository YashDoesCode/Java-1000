
public class InsertGreatestCommonDivisorsInLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) { int g = gcd(cur.val, cur.next.val);
            ListNode node = new ListNode(g, cur.next);
            cur.next = node;
            cur = node.next;
        } return head;
    } private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b);
    };
}
