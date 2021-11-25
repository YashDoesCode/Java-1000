
public class SplitLinkedListInParts {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) { cur = cur.next;
            len++;
        } int width = len / k, rem = len % k;
        ListNode[] res = new ListNode[k];
        cur = head;
        for (int i = 0;
        i < k;
        i++) { ListNode root = cur;
            for (int j = 0;
            j < width + (i < rem ? 1 : 0) - 1;
            j++) if (cur != null) cur = cur.next;
            if (cur != null) { ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            } res[i] = root;
        } return res;
    };
}
