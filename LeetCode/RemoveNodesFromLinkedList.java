
public class RemoveNodesFromLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = removeNodes(head.next);
        return head.val < head.next.val ? head.next : head;
    };
}
