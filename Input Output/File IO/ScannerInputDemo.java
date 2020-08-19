import java.util.*;
public class ScannerInputDemo {

    public void process() { Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) { int n = sc.nextInt();
            System.out.println("Num: " + n);
        } };
}
