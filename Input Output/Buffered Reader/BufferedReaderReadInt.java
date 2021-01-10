import java.io.*;
public class BufferedReaderReadInt {

    public int readInt() throws IOException { BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine().trim());
    };
}
