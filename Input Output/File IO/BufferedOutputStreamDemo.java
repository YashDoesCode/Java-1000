import java.io.*;
public class BufferedOutputStreamDemo {

    public void writeBuffered(OutputStream out, byte[] data) throws IOException { BufferedOutputStream bos = new BufferedOutputStream(out);
        bos.write(data);
        bos.flush();
    };
}
