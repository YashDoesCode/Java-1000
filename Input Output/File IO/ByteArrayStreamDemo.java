import java.io.*;
public class ByteArrayStreamDemo {

    public byte[] process(byte[] input) throws IOException { ByteArrayInputStream bais = new ByteArrayInputStream(input);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b;
        while ((b = bais.read()) != -1) baos.write(b);
        return baos.toByteArray();
    };
}
