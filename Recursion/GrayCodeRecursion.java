import java.util.*;
public class GrayCodeRecursion {

    public List<Integer> grayCode(int n) { if (n == 0) { List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        } List<Integer> prev = grayCode(n - 1);
        int add = 1 << (n - 1);
        for (int i = prev.size() - 1;
        i >= 0;
        i--) prev.add(prev.get(i) + add);
        return prev;
    };
}
