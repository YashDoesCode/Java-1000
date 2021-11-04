import java.util.*;
public class ScannerMultipleTypesDemo {

    public Object[] readMultiple(String input) { Scanner sc = new Scanner(input);
        int i = sc.nextInt();
        double d = sc.nextDouble();
        String s = sc.next();
        return new Object[]{i, d, s};
    };
}
