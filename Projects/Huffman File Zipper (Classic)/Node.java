import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;
    
    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
    
    Node(int freq) {
        this.freq = freq;
    }
}