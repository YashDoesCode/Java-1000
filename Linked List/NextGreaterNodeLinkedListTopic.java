import java.util.*;
public class NextGreaterNodeLinkedListTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public int[] nextLargerNodes(Node head) { List<Integer> list = new ArrayList<>();
        for (Node cur = head;
        cur != null;
        cur = cur.next) list.add(cur.val);
        int[] res = new int[list.size()];
        Stack<Integer> st = new Stack<>();
        for (int i = 0;
        i < list.size();
        i++) { while (!st.isEmpty() && list.get(st.peek()) < list.get(i)) res[st.pop()] = list.get(i);
            st.push(i);
        } return res;
    };
}
