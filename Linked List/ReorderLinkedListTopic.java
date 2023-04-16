public class ReorderLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public void reorderList(Node head) { if (head == null || head.next == null) return;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) { slow = slow.next;
            fast = fast.next.next;
        } Node prev = null, cur = slow.next;
        slow.next = null;
        while (cur != null) { Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } Node p1 = head, p2 = prev;
        while (p2 != null) { Node t1 = p1.next, t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        } };
}
