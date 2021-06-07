import java.io.*;
public class FileWriteBuffer {

    public void writeFile(String path, String content) throws IOException { try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) { bw.write(content);
        } };
}
