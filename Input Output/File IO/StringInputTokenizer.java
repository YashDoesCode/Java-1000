import java.util.*;
public class StringInputTokenizer {

    public List<String> tokenize(String s) { StringTokenizer st = new StringTokenizer(s);
        List<String> res = new ArrayList<>();
        while (st.hasMoreTokens()) res.add(st.nextToken());
        return res;
    };
}
