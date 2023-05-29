
public class PalindromeLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next;
            fast = fast.next.next;
        } ListNode prev = null, cur = slow;
        while (cur != null) { ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } while (prev != null) { if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        } return true;
    };
}
