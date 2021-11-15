
import java.util.*;
public class SieveOfEratosthenesMath {

    public List<Integer> sieve(int n) { boolean[] p = new boolean[n + 1];
        Arrays.fill(p, true);
        List<Integer> primes = new ArrayList<>();
        for (int i = 2;
        i <= n;
        i++) { if (p[i]) { primes.add(i);
                for (int j = i * 2;
                j <= n;
                j += i) p[j] = false;
            } } return primes;
    };
}
