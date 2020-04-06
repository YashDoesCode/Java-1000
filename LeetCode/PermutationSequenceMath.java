
import java.util.*;
public class PermutationSequenceMath {

    public String getPermutation(int n, int k) { List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1;
        i <= n;
        i++) { fact[i] = fact[i - 1] * i;
            numbers.add(i);
        } k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 1;
        i <= n;
        i++) { int idx = k / fact[n - i];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k %= fact[n - i];
        } return sb.toString();
    };
}
