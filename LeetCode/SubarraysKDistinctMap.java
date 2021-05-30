
import java.util.*;
public class SubarraysKDistinctMap {

    public int subarraysWithKDistinct(int[] A, int K) { return atMostK(A, K) - atMostK(A, K - 1);
    } private int atMostK(int[] A, int K) { Map<Integer, Integer> count = new HashMap<>();
        int l = 0, res = 0;
        for (int r = 0;
        r < A.length;
        r++) { if (count.getOrDefault(A[r], 0) == 0) K--;
            count.put(A[r], count.getOrDefault(A[r], 0) + 1);
            while (K < 0) { count.put(A[l], count.get(A[l]) - 1);
                if (count.get(A[l]) == 0) K++;
                l++;
            } res += r - l + 1;
        } return res;
    };
}
