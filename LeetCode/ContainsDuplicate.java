
import java.util.*;
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) { Set<Integer> s = new HashSet<>();
        for (int x : nums) if (!s.add(x)) return true;
        return false;
    };
}
