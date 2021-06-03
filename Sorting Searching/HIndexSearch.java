import java.util.*;
public class HIndexSearch {

    public int hIndex(int[] c) { Arrays.sort(c);
        int n = c.length;
        for (int i = 0;
        i < n;
        i++) if (c[i] >= n - i) return n - i;
        return 0;
    };
}
