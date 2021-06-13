public class AddTwoNumbersLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node addTwoNumbers(Node l1, Node l2) { Node dummy = new Node(0), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) { int sum = carry;
            if (l1 != null) { sum += l1.val;
                l1 = l1.next;
            } if (l2 != null) { sum += l2.val;
                l2 = l2.next;
            } carry = sum / 10;
            cur.next = new Node(sum % 10);
            cur = cur.next;
        } return dummy.next;
    };
}
