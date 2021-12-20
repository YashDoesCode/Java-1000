import java.util.*;
public class PrimeFactorsList {

    public List<Integer> getFactors(int n) { List<Integer> factors = new ArrayList<>();
        for (int i = 2;
        i * i <= n;
        i++) { while (n % i == 0) { factors.add(i);
                n /= i;
            } } if (n > 1) factors.add(n);
        return factors;
    };
}
