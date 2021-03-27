public class ReverseLinkedListIITopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node reverseBetween(Node head, int left, int right) { if (head == null) return null;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for (int i = 0;
        i < left - 1;
        i++) prev = prev.next;
        Node start = prev.next, then = start.next;
        for (int i = 0;
        i < right - left;
        i++) { start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        } return dummy.next;
    };
}
