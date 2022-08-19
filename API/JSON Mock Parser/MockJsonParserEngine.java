import java.util.*;

public class MockJsonParserEngine {

    public Map<String, String> parseSimpleJson(String json) {
        Map<String, String> result = new HashMap<>();
        if (json == null) return result;
        json = json.trim();
        if (json.startsWith("{") && json.endsWith("}")) {
            json = json.substring(1, json.length() - 1);
            String[] pairs = json.split(",");
            for (String pair : pairs) {
                String[] kv = pair.split(":");
                if (kv.length == 2) {
                    result.put(kv[0].trim().replace("\"", ""), kv[1].trim().replace("\"", ""));
                }
            }
        }
        return result;
    }
}
