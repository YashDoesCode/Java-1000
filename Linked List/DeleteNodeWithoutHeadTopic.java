public class DeleteNodeWithoutHeadTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public void deleteNode(Node node) { node.val = node.next.val;
        node.next = node.next.next;
    };
}
