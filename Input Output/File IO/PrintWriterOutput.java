import java.io.*;
public class PrintWriterOutput {

    public void writeData(PrintWriter pw, String msg) { pw.println(msg);
        pw.flush();
    };
}
