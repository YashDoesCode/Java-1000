public class DeleteMiddleNodeLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node deleteMiddle(Node head) { if (head == null || head.next == null) return null;
        Node slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
        } slow.next = slow.next.next;
        return head;
    };
}
