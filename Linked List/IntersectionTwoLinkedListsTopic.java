public class IntersectionTwoLinkedListsTopic {

    class Node { int val;

        Node next;
        Node(int v) { val = v;
        } } public Node getIntersection(Node h1, Node h2) { Node a = h1, b = h2;
        while (a != b) { a = (a == null) ? h2 : a.next;
            b = (b == null) ? h1 : b.next;
        } return a;
    };
}
