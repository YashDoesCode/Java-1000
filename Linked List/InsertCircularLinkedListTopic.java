public class InsertCircularLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node insert(Node head, int insertVal) { if (head == null) { Node node = new Node(insertVal);
            node.next = node;
            return node;
        } Node prev = head, cur = head.next;
        boolean toInsert = false;
        do { if (prev.val <= insertVal && insertVal <= cur.val) toInsert = true;
            else if (prev.val > cur.val) { if (insertVal >= prev.val || insertVal <= cur.val) toInsert = true;
            } if (toInsert) { Node node = new Node(insertVal);
                prev.next = node;
                node.next = cur;
                return head;
            } prev = cur;
            cur = cur.next;
        } while (prev != head);
        Node node = new Node(insertVal);
        prev.next = node;
        node.next = cur;
        return head;
    };
}
