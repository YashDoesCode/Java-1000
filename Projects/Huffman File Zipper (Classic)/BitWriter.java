import java.io.*;

class BitWriter {
    private FileOutputStream fos;
    private int buffer = 0;
    private int count = 0;
    
    public BitWriter(String filename) throws IOException {
        fos = new FileOutputStream(filename);
    }
    
    public void writeBit(int bit) throws IOException {
        buffer = (buffer << 1) | (bit & 1);
        count++;
        
        if (count == 8) {
            fos.write(buffer);
            buffer = 0;
            count = 0;
        }
    }
    
    public void writeBits(String bits) throws IOException {
        for (char bit : bits.toCharArray()) {
            writeBit(bit - '0');
        }
    }
    
    public void close() throws IOException {
        while (count > 0) {
            writeBit(0);
        }
        fos.close();
    }
}