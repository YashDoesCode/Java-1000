public class RemoveDuplicatesLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node removeDuplicates(Node head) { Node cur = head;
        while (cur != null && cur.next != null) { if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        } return head;
    };
}
