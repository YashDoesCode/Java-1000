public class RemoveNodesFromLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node removeNodes(Node head) { if (head == null || head.next == null) return head;
        head.next = removeNodes(head.next);
        return head.val < head.next.val ? head.next : head;
    };
}
