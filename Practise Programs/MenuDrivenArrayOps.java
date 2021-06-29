import java.util.*;
public class MenuDrivenArrayOps {

    public int[] process(int[] a, int choice) { switch (choice) { case 1: Arrays.sort(a);
            return a;
            case 2: int[] rev = a.clone();
            for (int i = 0;
            i < rev.length / 2;
            i++) { int t = rev[i];
                rev[i] = rev[rev.length - 1 - i];
                rev[rev.length - 1 - i] = t;
            } return rev;
            default: return a;
        } };
}
