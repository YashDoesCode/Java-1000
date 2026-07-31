import java.util.*;
import java.io.*;

public class HuffmanEngine {
    private Map<Character, String> codes = new HashMap<>();
    private Map<Character, Integer> lastFreq;
    private Node root;
    
    public void comp(String inFile, String outFile) throws IOException {
        String text = readFile(inFile);
        lastFreq = buildFreq(text);
        root = buildTree(lastFreq);
        buildCodes(root, "");
        
        String enc = encode(text);
        save(outFile, enc, lastFreq);
    }
    
    public void decomp(String inFile, String outFile) throws IOException, ClassNotFoundException {
        CompData data = load(inFile);
        root = buildTree(data.freq);
        String dec = decode(data.enc);
        writeFile(outFile, dec);
    }
    
    public Map<Character, Integer> getLastFreq() {
        return lastFreq;
    }
    
    private String readFile(String file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    
    private Map<Character, Integer> buildFreq(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }
    
    private Node buildTree(Map<Character, Integer> freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            pq.offer(new Node(e.getKey(), e.getValue()));
        }
        
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            
            Node merged = new Node('\0', left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            
            pq.offer(merged);
        }
        
        return pq.poll();
    }
    
    private void buildCodes(Node node, String code) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            codes.put(node.ch, code.isEmpty() ? "0" : code);
            return;
        }
        
        buildCodes(node.left, code + "0");
        buildCodes(node.right, code + "1");
    }
    
    private String encode(String text) {
        StringBuilder enc = new StringBuilder();
        for (char ch : text.toCharArray()) {
            enc.append(codes.get(ch));
        }
        return enc.toString();
    }
    
    private String decode(String enc) {
        StringBuilder dec = new StringBuilder();
        Node cur = root;
        
        for (char bit : enc.toCharArray()) {
            cur = (bit == '0') ? cur.left : cur.right;
            
            if (cur.left == null && cur.right == null) {
                dec.append(cur.ch);
                cur = root;
            }
        }
        
        return dec.toString();
    }
    
    private void save(String file, String enc, Map<Character, Integer> freq) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            CompData data = new CompData(enc, freq);
            out.writeObject(data);
        }
    }
    
    private CompData load(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (CompData) in.readObject();
        }
    }
    
    private void writeFile(String file, String content) throws IOException {
        try (PrintWriter w = new PrintWriter(new FileWriter(file))) {
            w.write(content);
        }
    }
    
    public Node getRoot() {
        return root;
    }
    
    public Map<Character, String> getCodes() {
        return new HashMap<>(codes);
    }
    
    static class Node {
        char ch;
        int freq;
        Node left, right;
        
        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    static class CompData implements Serializable {
        String enc;
        Map<Character, Integer> freq;
        
        CompData(String enc, Map<Character, Integer> freq) {
            this.enc = enc;
            this.freq = freq;
        }
    }
}