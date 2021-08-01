public class PalindromeLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public boolean isPalindrome(Node head) { Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
        } Node prev = null, cur = slow;
        while (cur != null) { Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } while (prev != null) { if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        } return true;
    };
}
