import java.io.*;

class BitReader {
    private FileInputStream fis;
    private int buffer = 0;
    private int count = 0;
    
    public BitReader(String filename) throws IOException {
        fis = new FileInputStream(filename);
    }
    
    public int readBit() throws IOException {
        if (count == 0) {
            buffer = fis.read();
            if (buffer == -1) return -1;
            count = 8;
        }
        
        int bit = (buffer >> (count - 1)) & 1;
        count--;
        return bit;
    }
    
    public void close() throws IOException {
        fis.close();
    }
}