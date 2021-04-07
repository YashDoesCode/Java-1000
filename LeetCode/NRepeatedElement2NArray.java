
import java.util.*;
public class NRepeatedElement2NArray {

    public int repeatedNTimes(int[] A) { Set<Integer> s = new HashSet<>();
        for (int a : A) if (!s.add(a)) return a;
        return -1;
    };
}
