import java.util.*;
public class SimpleJsonParser {

    public Map<String, String> parseKeyValue(String json) {
        Map<String, String> map = new HashMap<>();
        if (json == null) return map;
        json = json.trim();
        if (json.startsWith("{") && json.endsWith("}")) json = json.substring(1, json.length() - 1);
        String[] pairs = json.split(",");
        for (String p : pairs) {
            String[] kv = p.split(":");
            if (kv.length == 2) {
                String k = kv[0].trim().replace("\"", "");
                String v = kv[1].trim().replace("\"", "");
                map.put(k, v);
            }
        }
        return map;
    }
}
