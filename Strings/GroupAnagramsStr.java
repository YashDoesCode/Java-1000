import java.util.*;
public class GroupAnagramsStr {

    public List<List<String>> group(String[] strs) { Map<String, List<String>> mp = new HashMap<>();
        for (String s : strs) { char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(s);
        } return new ArrayList<>(mp.values());
    };
}
