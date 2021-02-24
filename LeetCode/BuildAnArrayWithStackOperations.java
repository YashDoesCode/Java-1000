
import java.util.*;
public class BuildAnArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) { List<String> res = new ArrayList<>();
        int cur = 1;
        for (int num : target) { while (cur < num) { res.add("Push");
                res.add("Pop");
                cur++;
            } res.add("Push");
            cur++;
        } return res;
    };
}
