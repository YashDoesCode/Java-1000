
import java.util.*;
public class HappyNumberMath {

    public boolean isHappy(int n) { Set<Integer> s = new HashSet<>();
        while (n != 1 && s.add(n)) { int sum = 0;
            while (n > 0) { int d = n % 10;
                sum += d * d;
                n /= 10;
            } n = sum;
        } return n == 1;
    };
}
