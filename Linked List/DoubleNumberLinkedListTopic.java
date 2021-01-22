public class DoubleNumberLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node doubleIt(Node head) { if (head.val >= 5) { Node n = new Node(0);
            n.next = head;
            head = n;
        } for (Node cur = head;
        cur != null;
        cur = cur.next) { cur.val = (cur.val * 2) % 10;
            if (cur.next != null && cur.next.val >= 5) cur.val++;
        } return head;
    };
}
