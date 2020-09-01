import java.io.*;

public class FastReaderEngine {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readNextLine() throws IOException {
        return reader.readLine();
    }
}
