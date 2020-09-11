
public class MergeNodesBetweenZeros {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy, p = head.next;
        int sum = 0;
        while (p != null) { if (p.val == 0) { cur.next = new ListNode(sum);
                cur = cur.next;
                sum = 0;
            } else sum += p.val;
            p = p.next;
        } return dummy.next;
    };
}
