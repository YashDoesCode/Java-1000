import java.util.*;
import java.io.*;

public class HuffmanZipper {
    private Map<Character, String> codes = new HashMap<>();
    private Node root;
    
    public void compress(String inputFile, String outputFile) {
        try {
            String text = readFile(inputFile);
            Map<Character, Integer> freqMap = getFrequency(text);
            root = buildTree(freqMap);
            buildCodes(root, "");
            
            String encoded = encode(text);
            writeCompressed(outputFile, encoded, freqMap);
            
            System.out.println("File compressed successfully!");
            showStats(inputFile, outputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void decompress(String inputFile, String outputFile) {
        try {
            Object[] data = readCompressed(inputFile);
            String encoded = (String) data[0];
            Map<Character, Integer> freqMap = (Map<Character, Integer>) data[1];
            
            root = buildTree(freqMap);
            String decoded = decode(encoded);
            writeFile(outputFile, decoded);
            
            System.out.println("File decompressed successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private String readFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }
    
    private Map<Character, Integer> getFrequency(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return freqMap;
    }
    
    private Node buildTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }
        
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
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
        StringBuilder encoded = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encoded.append(codes.get(ch));
        }
        return encoded.toString();
    }
    
    private String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        Node current = root;
        
        for (char bit : encoded.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;
            
            if (current.left == null && current.right == null) {
                decoded.append(current.ch);
                current = root;
            }
        }
        
        return decoded.toString();
    }
    
    private void writeCompressed(String filename, String encoded, Map<Character, Integer> freqMap) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(encoded);
        oos.writeObject(freqMap);
        oos.close();
    }
    
    private Object[] readCompressed(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        String encoded = (String) ois.readObject();
        Map<Character, Integer> freqMap = (Map<Character, Integer>) ois.readObject();
        ois.close();
        return new Object[]{encoded, freqMap};
    }
    
    private void writeFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
    
    private void showStats(String inputFile, String outputFile) {
        try {
            File input = new File(inputFile);
            File output = new File(outputFile);
            long originalSize = input.length();
            long compressedSize = output.length();
            double ratio = (double) compressedSize / originalSize * 100;
            
            System.out.println("Original size: " + originalSize + " bytes");
            System.out.println("Compressed size: " + compressedSize + " bytes");
            System.out.println("Compression ratio: " + String.format("%.2f", ratio) + "%");
        } catch (Exception e) {
            System.out.println("Could not calculate stats");
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java HuffmanZipper <compress/decompress> <input_file> <output_file>");
            return;
        }
        
        HuffmanZipper zipper = new HuffmanZipper();
        String operation = args[0];
        String inputFile = args[1];
        String outputFile = args[2];
        
        if (operation.equals("compress")) {
            zipper.compress(inputFile, outputFile);
        } else if (operation.equals("decompress")) {
            zipper.decompress(inputFile, outputFile);
        } else {
            System.out.println("Invalid operation. Use 'compress' or 'decompress'");
        }
    }
}