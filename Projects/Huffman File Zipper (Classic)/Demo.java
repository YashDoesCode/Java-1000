public class Demo {
    public static void main(String[] args) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("sample.txt");
            writer.write("This is a sample text file for testing Huffman compression algorithm. ");
            writer.write("It contains repeated characters which should compress well. ");
            writer.write("The quick brown fox jumps over the lazy dog multiple times. ");
            writer.write("Hello world hello world hello world!");
            writer.close();
            
            System.out.println("Sample file created: sample.txt");
            System.out.println("Run: java HuffmanZipper compress sample.txt compressed.huf");
            System.out.println("Run: java HuffmanZipper decompress compressed.huf decompressed.txt");
            
        } catch (Exception e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
}