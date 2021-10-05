
public class ReverseNodesInKGroup {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null && cnt != k) { cur = cur.next;
            cnt++;
        } if (cnt == k) { cur = reverseKGroup(cur, k);
            while (cnt-- > 0) { ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            } head = cur;
        } return head;
    };
}
