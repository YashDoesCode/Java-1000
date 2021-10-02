import java.util.*;
public class MergeKListsTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node mergeKLists(Node[] lists) { PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (Node n : lists) if (n != null) pq.add(n);
        Node dummy = new Node(0), cur = dummy;
        while (!pq.isEmpty()) { Node top = pq.poll();
            cur.next = top;
            cur = cur.next;
            if (top.next != null) pq.add(top.next);
        } return dummy.next;
    };
}
