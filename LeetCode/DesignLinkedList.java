
public class DesignLinkedList {

    class Node { int val;

        Node next;
        Node(int val) { this.val = val;
        } } private Node head;

    private int size;

    public DesignLinkedList() { head = null;
        size = 0;
    } public int get(int index) { if (index < 0 || index >= size) return -1;
        Node cur = head;
        for (int i = 0;
        i < index;
        i++) cur = cur.next;
        return cur.val;
    } public void addAtHead(int val) { Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    } public void addAtTail(int val) { if (size == 0) { addAtHead(val);
            return;
        } Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = new Node(val);
        size++;
    } public void addAtIndex(int index, int val) { if (index < 0 || index > size) return;
        if (index == 0) { addAtHead(val);
            return;
        } Node cur = head;
        for (int i = 0;
        i < index - 1;
        i++) cur = cur.next;
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    } public void deleteAtIndex(int index) { if (index < 0 || index >= size) return;
        if (index == 0) { head = head.next;
            size--;
            return;
        } Node cur = head;
        for (int i = 0;
        i < index - 1;
        i++) cur = cur.next;
        cur.next = cur.next.next;
        size--;
    };
}
