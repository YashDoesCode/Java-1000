import java.util.*;
public class KthDistinctStringMap {

    public String kthDistinct(String[] arr, int k) { Map<String, Integer> mp = new LinkedHashMap<>();
        for (String s : arr) mp.put(s, mp.getOrDefault(s, 0) + 1);
        for (String s : mp.keySet()) if (mp.get(s) == 1) { k--;
            if (k == 0) return s;
        } return "";
    };
}
