import java.io.*;

public class FileStreamEngine {

    public boolean fileExists(String path) {
        return new File(path).exists();
    }
}
