import java.io.*;
public class PipedInputOutputStreamDemo {

    public void connect() throws IOException { PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        pos.write(65);
        pos.close();
        pis.read();
        pis.close();
    };
}
