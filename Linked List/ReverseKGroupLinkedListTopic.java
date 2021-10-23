public class ReverseKGroupLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node reverseKGroup(Node head, int k) { Node cur = head;
        int cnt = 0;
        while (cur != null && cnt != k) { cur = cur.next;
            cnt++;
        } if (cnt == k) { cur = reverseKGroup(cur, k);
            while (cnt-- > 0) { Node temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            } head = cur;
        } return head;
    };
}
