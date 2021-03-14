public class RotateLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node rotateRight(Node head, int k) { if (head == null || head.next == null) return head;
        Node cur = head;
        int len = 1;
        while (cur.next != null) { cur = cur.next;
            len++;
        } cur.next = head;
        k = len - k % len;
        for (int i = 0;
        i < k;
        i++) cur = cur.next;
        Node newHead = cur.next;
        cur.next = null;
        return newHead;
    };
}
