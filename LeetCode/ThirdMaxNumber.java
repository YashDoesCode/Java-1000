
import java.util.*;
public class ThirdMaxNumber {

    public int thirdMax(int[] nums) { Long f = null, s = null, t = null;
        for (int n : nums) { long v = n;
            if ((f != null && v == f) || (s != null && v == s) || (t != null && v == t)) continue;
            if (f == null || v > f) { t = s;
                s = f;
                f = v;
            } else if (s == null || v > s) { t = s;
                s = v;
            } else if (t == null || v > t) { t = v;
            } } return t == null ? f.intValue() : t.intValue();
    };
}
