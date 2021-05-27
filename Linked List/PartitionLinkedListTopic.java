public class PartitionLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node partition(Node head, int x) { Node bHead = new Node(0), sHead = new Node(0);
        Node b = bHead, s = sHead;
        while (head != null) { if (head.val < x) { s.next = head;
                s = s.next;
            } else { b.next = head;
                b = b.next;
            } head = head.next;
        } b.next = null;
        s.next = bHead.next;
        return sHead.next;
    };
}
