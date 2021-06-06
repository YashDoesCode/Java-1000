public class MergeNodesBetweenZerosTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node mergeNodes(Node head) { Node dummy = new Node(0), cur = dummy, p = head.next;
        int sum = 0;
        while (p != null) { if (p.val == 0) { cur.next = new Node(sum);
                cur = cur.next;
                sum = 0;
            } else sum += p.val;
            p = p.next;
        } return dummy.next;
    };
}
