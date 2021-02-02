public class SwappingNodesLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node swapNodes(Node head, int k) { Node n1 = null, n2 = null, cur = head;
        int len = 0;
        while (cur != null) { len++;
            if (n2 != null) n2 = n2.next;
            if (len == k) { n1 = cur;
                n2 = head;
            } cur = cur.next;
        } int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
        return head;
    };
}
