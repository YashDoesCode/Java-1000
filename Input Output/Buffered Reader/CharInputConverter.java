import java.io.*;
public class CharInputConverter {

    public char readChar() throws IOException { BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return (char) br.read();
    };
}
