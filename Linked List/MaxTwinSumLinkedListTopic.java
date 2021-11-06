public class MaxTwinSumLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public int pairSum(Node head) { Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
        } Node prev = null, cur = slow;
        while (cur != null) { Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } int maxV = 0;
        Node p1 = head, p2 = prev;
        while (p2 != null) { maxV = Math.max(maxV, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        } return maxV;
    };
}
