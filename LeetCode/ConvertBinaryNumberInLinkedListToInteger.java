
public class ConvertBinaryNumberInLinkedListToInteger {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) { ans = (ans << 1) | head.val;
            head = head.next;
        } return ans;
    };
}
