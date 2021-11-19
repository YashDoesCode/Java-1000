
import java.util.*;
public class SubsetsIIBitwise {

    public List<List<Integer>> subsetsWithDup(int[] nums) { Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0;
        i < (1 << n);
        i++) { List<Integer> cur = new ArrayList<>();
            boolean valid = true;
            for (int j = 0;
            j < n;
            j++) { if ((i & (1 << j)) != 0) { if (j > 0 && (i & (1 << (j - 1))) == 0 && nums[j] == nums[j - 1]) { valid = false;
                        break;
                    } cur.add(nums[j]);
                } } if (valid) res.add(cur);
        } return res;
    };
}
