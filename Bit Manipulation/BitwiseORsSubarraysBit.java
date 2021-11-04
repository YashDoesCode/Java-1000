import java.util.*;
public class BitwiseORsSubarraysBit {

    public int subarrayBitwiseORs(int[] arr) { Set<Integer> res = new HashSet<>(), cur = new HashSet<>();
        for (int i : arr) { Set<Integer> cur2 = new HashSet<>();
            cur2.add(i);
            for (int j : cur) cur2.add(i | j);
            res.addAll(cur = cur2);
        } return res.size();
    };
}
