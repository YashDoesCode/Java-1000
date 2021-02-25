
public class TrieNodeStructure {

    class Node { Node[] child = new Node[26];

        boolean isEnd = false;
    } private Node root = new Node();

    public void insert(String word) { Node cur = root;
        for (char c : word.toCharArray()) { int idx = c - 'a';
            if (cur.child[idx] == null) cur.child[idx] = new Node();
            cur = cur.child[idx];
        } cur.isEnd = true;
    } public boolean search(String word) { Node cur = root;
        for (char c : word.toCharArray()) { int idx = c - 'a';
            if (cur.child[idx] == null) return false;
            cur = cur.child[idx];
        } return cur.isEnd;
    };
}
