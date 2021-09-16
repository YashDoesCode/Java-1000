
public class InsertIntoSortedCircularLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {} ListNode(int val) { this.val = val;
        } ListNode(int val, ListNode next) { this.val = val;
            this.next = next;
        };
    }

    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) { ListNode node = new ListNode(insertVal);
            node.next = node;
            return node;
        } ListNode prev = head, cur = head.next;
        boolean toInsert = false;
        do { if (prev.val <= insertVal && insertVal <= cur.val) toInsert = true;
            else if (prev.val > cur.val) { if (insertVal >= prev.val || insertVal <= cur.val) toInsert = true;
            } if (toInsert) { prev.next = new ListNode(insertVal, cur);
                return head;
            } prev = cur;
            cur = cur.next;
        } while (prev != head);
        prev.next = new ListNode(insertVal, cur);
        return head;
    };
}
