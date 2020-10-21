import java.io.*;
public class SequenceInputStreamDemo {

    public byte[] mergeStreams(InputStream in1, InputStream in2) throws IOException { SequenceInputStream sis = new SequenceInputStream(in1, in2);
        return sis.readAllBytes();
    };
}
