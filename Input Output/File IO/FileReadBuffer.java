import java.io.*;
public class FileReadBuffer {

    public String readFile(String path) throws IOException { StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) { String line;
            while ((line = br.readLine()) != null) sb.append(line).append("\n");
        } return sb.toString();
    };
}
