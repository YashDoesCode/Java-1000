public class InsertGCDLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node insertGreatestCommonDivisors(Node head) { Node cur = head;
        while (cur != null && cur.next != null) { int g = gcd(cur.val, cur.next.val);
            Node node = new Node(g);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        } return head;
    } private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b);
    };
}
