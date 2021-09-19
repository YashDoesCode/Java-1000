public class SplitLinkedListPartsTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node[] splitListToParts(Node head, int k) { Node cur = head;
        int len = 0;
        while (cur != null) { cur = cur.next;
            len++;
        } int width = len / k, rem = len % k;
        Node[] res = new Node[k];
        cur = head;
        for (int i = 0;
        i < k;
        i++) { Node root = cur;
            for (int j = 0;
            j < width + (i < rem ? 1 : 0) - 1;
            j++) if (cur != null) cur = cur.next;
            if (cur != null) { Node prev = cur;
                cur = cur.next;
                prev.next = null;
            } res[i] = root;
        } return res;
    };
}
