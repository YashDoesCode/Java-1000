
import java.util.*;
public class CloneGraphStructure {

    class Node { public int val;

        public List<Node> neighbors;

        public Node() { val = 0;
            neighbors = new ArrayList<>();
        } public Node(int val) { this.val = val;
            neighbors = new ArrayList<>();
        } } private Map<Node, Node> mp = new HashMap<>();

    public Node cloneGraph(Node node) { if (node == null) return null;
        if (mp.containsKey(node)) return mp.get(node);
        Node copy = new Node(node.val);
        mp.put(node, copy);
        for (Node nbr : node.neighbors) copy.neighbors.add(cloneGraph(nbr));
        return copy;
    };
}
