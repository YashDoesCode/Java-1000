import java.util.*;

public class MergeKSortedListsPQ {

    public static class ListNode {

        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) pq.add(curr.next);
        }
        return dummy.next;
    }
}
