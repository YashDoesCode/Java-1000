import java.util.*;
public class FourSumIIMap {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) { Map<Integer, Integer> mp = new HashMap<>();
        for (int a : A) for (int b : B) mp.put(a + b, mp.getOrDefault(a + b, 0) + 1);
        int cnt = 0;
        for (int c : C) for (int d : D) cnt += mp.getOrDefault(-(c + d), 0);
        return cnt;
    };
}
