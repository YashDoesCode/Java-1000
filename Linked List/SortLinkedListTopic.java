public class SortLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node sortList(Node head) { if (head == null || head.next == null) return head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
        } Node mid = slow.next;
        slow.next = null;
        Node l1 = sortList(head), l2 = sortList(mid);
        Node dummy = new Node(0), cur = dummy;
        while (l1 != null && l2 != null) { if (l1.val < l2.val) { cur.next = l1;
                l1 = l1.next;
            } else { cur.next = l2;
                l2 = l2.next;
            } cur = cur.next;
        } cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    };
}
