
import java.util.*;
public class MergeKSortedLists {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) if (node != null) pq.add(node);
        ListNode dummy = new ListNode(0), cur = dummy;
        while (!pq.isEmpty()) { ListNode top = pq.poll();
            cur.next = top;
            cur = cur.next;
            if (top.next != null) pq.add(top.next);
        } return dummy.next;
    };
}
