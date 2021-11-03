import java.util.*;
public class LRUCacheHashMap {

    class Node { int key, val;

        Node prev, next;
        Node(int k, int v) { key = k;
            val = v;
        } } private Map<Integer, Node> mp = new HashMap<>();

    private int cap;
    private Node head, tail;

    public LRUCacheHashMap(int capacity) { cap = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    } public int get(int key) { if (!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        remove(node);
        insert(node);
        return node.val;
    } public void put(int key, int value) { if (mp.containsKey(key)) remove(mp.get(key));
        if (mp.size() == cap) remove(tail.prev);
        insert(new Node(key, value));
    } private void remove(Node node) { mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    } private void insert(Node node) { mp.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    };
}
