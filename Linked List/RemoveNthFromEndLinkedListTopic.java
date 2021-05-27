public class RemoveNthFromEndLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node removeNth(Node head, int n) { Node dummy = new Node(0);
        dummy.next = head;
        Node p1 = dummy, p2 = dummy;
        for (int i = 0;
        i <= n;
        i++) p1 = p1.next;
        while (p1 != null) { p1 = p1.next;
            p2 = p2.next;
        } p2.next = p2.next.next;
        return dummy.next;
    };
}
