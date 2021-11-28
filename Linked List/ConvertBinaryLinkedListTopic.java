public class ConvertBinaryLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public int getDecimalValue(Node head) { int ans = 0;
        while (head != null) { ans = (ans << 1) | head.val;
            head = head.next;
        } return ans;
    };
}
