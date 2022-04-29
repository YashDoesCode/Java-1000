public class SwapPairsLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node swapPairs(Node head) { if (head == null || head.next == null) return head;
        Node next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    };
}
