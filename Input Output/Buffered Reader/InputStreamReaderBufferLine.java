import java.io.*;
public class InputStreamReaderBufferLine {

    public String readLineFromConsole() throws IOException { BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    };
}
