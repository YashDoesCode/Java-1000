import java.util.*;
public class SievePrimes {

    public List<Integer> getPrimes(int n) { boolean[] p = new boolean[n + 1];
        Arrays.fill(p, true);
        List<Integer> res = new ArrayList<>();
        for (int i = 2;
        i <= n;
        i++) if (p[i]) { res.add(i);
            for (int j = i * 2;
            j <= n;
            j += i) p[j] = false;
        } return res;
    };
}
