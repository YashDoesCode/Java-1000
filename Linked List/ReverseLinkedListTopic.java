public class ReverseLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node reverse(Node head) { Node prev = null, cur = head;
        while (cur != null) { Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } return prev;
    };
}
