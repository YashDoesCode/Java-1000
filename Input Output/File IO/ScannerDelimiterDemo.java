import java.util.*;
public class ScannerDelimiterDemo {

    public List<String> parseComma(String input) { Scanner sc = new Scanner(input);
        sc.useDelimiter(",");
        List<String> res = new ArrayList<>();
        while (sc.hasNext()) res.add(sc.next());
        return res;
    };
}
