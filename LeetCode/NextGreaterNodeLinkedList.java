
import java.util.*;
public class NextGreaterNodeLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode cur = head;
        cur != null;
        cur = cur.next) list.add(cur.val);
        int[] res = new int[list.size()];
        Stack<Integer> st = new Stack<>();
        for (int i = 0;
        i < list.size();
        i++) { while (!st.isEmpty() && list.get(st.peek()) < list.get(i)) res[st.pop()] = list.get(i);
            st.push(i);
        } return res;
    };
}
