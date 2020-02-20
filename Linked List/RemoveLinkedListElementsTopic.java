public class RemoveLinkedListElementsTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node removeElements(Node head, int val) { Node dummy = new Node(0);
        dummy.next = head;
        Node cur = dummy;
        while (cur.next != null) { if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        } return dummy.next;
    };
}
