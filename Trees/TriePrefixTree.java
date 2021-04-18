/*
 * Popular Question: Implement Trie (Prefix Tree)
 * Source: LeetCode #208 (Medium)
 *
 * Problem Statement:
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve
 * keys in a dataset of strings. There are various applications of this data structure, such as autocomplete
 * and spellchecker.
 *
 * Implement the TriePrefixTree class:
 * - TriePrefixTree() Initializes the trie object.
 * - void insert(String word) Inserts the string word into the trie.
 * - boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * - boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 * Example 1:
 * Input:
 * ["TriePrefixTree", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output:
 * [null, null, true, false, true, null, true]
 *
 * Constraints:
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 */

public class TriePrefixTree {

    private static class TrieNode {
        private final TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private final TrieNode root;

    public TriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return null;
            }
            curr = curr.children[idx];
        }
        return curr;
    }

    public static void main(String[] args) {
        TriePrefixTree trie = new TriePrefixTree();

        trie.insert("apple");
        System.out.println("search('apple'): " + trie.search("apple"));
        System.out.println("search('app'): " + trie.search("app"));
        System.out.println("startsWith('app'): " + trie.startsWith("app"));

        trie.insert("app");
        System.out.println("search('app') after inserting 'app': " + trie.search("app"));
    }
}
