import java.io.*;
public class RandomAccessFileDemo {

    public int readAt(String path, long pos) throws IOException { try (RandomAccessFile raf = new RandomAccessFile(path, "r")) { raf.seek(pos);
            return raf.readInt();
        } };
}
