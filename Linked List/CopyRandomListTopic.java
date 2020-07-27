import java.util.*;
public class CopyRandomListTopic {

    class Node { int val;

        Node next, random;
        Node(int v) { val = v;
        } } public Node copyRandomList(Node head) { if (head == null) return null;
        Map<Node, Node> mp = new HashMap<>();
        Node cur = head;
        while (cur != null) { mp.put(cur, new Node(cur.val));
            cur = cur.next;
        } cur = head;
        while (cur != null) { mp.get(cur).next = mp.get(cur.next);
            mp.get(cur).random = mp.get(cur.random);
            cur = cur.next;
        } return mp.get(head);
    };
}
