import java.io.*;
public class ConsoleReaderDemo {

    public String readConsole() { Console c = System.console();
        return c != null ? c.readLine() : "";
    };
}
