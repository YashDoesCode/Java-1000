public class DetectCycleLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public boolean hasCycle(Node head) { Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        } return false;
    };
}
