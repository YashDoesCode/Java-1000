public class CircularLinkedList {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } private Node head;

    public void add(int v) { Node node = new Node(v);
        if (head == null) { head = node;
            node.next = head;
        } else { Node cur = head;
            while (cur.next != head) cur = cur.next;
            cur.next = node;
            node.next = head;
        } };
}
