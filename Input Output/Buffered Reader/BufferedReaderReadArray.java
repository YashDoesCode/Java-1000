import java.io.*;
public class BufferedReaderReadArray {

    public int[] readArray() throws IOException { BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split("\\s+");
        int[] a = new int[s.length];
        for (int i = 0;
        i < s.length;
        i++) a[i] = Integer.parseInt(s[i]);
        return a;
    };
}
