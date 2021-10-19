public class OddEvenLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node oddEvenList(Node head) { if (head == null) return null;
        Node odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) { odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        } odd.next = evenHead;
        return head;
    };
}
