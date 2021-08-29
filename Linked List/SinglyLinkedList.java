public class SinglyLinkedList {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } private Node head;

    public void add(int v) { Node node = new Node(v);
        node.next = head;
        head = node;
    };
}
