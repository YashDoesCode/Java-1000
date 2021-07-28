public class DoublyLinkedList {

    class Node { int val;

        Node prev, next;
        Node(int v) { val = v;
        } } private Node head, tail;

    public void addLast(int v) { Node node = new Node(v);
        if (tail == null) head = tail = node;
        else { tail.next = node;
            node.prev = tail;
            tail = node;
        } };
}
