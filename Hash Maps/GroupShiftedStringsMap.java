import java.util.*;
public class GroupShiftedStringsMap {

    public List<List<String>> groupStrings(String[] strings) { Map<String, List<String>> mp = new HashMap<>();
        for (String s : strings) { String key = getKey(s);
            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(s);
        } return new ArrayList<>(mp.values());
    } private String getKey(String s) { StringBuilder sb = new StringBuilder();
        for (int i = 1;
        i < s.length();
        i++) { int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
            sb.append(diff).append("#");
        } return sb.toString();
    };
}
