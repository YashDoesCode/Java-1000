import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class UrlParamFilter {

    private final Map<String, String> queryParams = new LinkedHashMap<>();

    public void addParam(String key, String value) {
        queryParams.put(key, value);
    }

    public String buildEncodedUrl(String baseUrl) {
        StringBuilder sb = new StringBuilder(baseUrl);
        if (!queryParams.isEmpty()) {
            sb.append("?");
            boolean first = true;
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                if (!first) sb.append("&");
                sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
                first = false;
            }
        }
        return sb.toString();
    }

    public static Map<String, String> parseQueryParams(String queryString) {
        Map<String, String> map = new LinkedHashMap<>();
        if (queryString == null || queryString.isEmpty()) return map;
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            String[] kv = pair.split("=");
            if (kv.length == 2) {
                map.put(URLDecoder.decode(kv[0], StandardCharsets.UTF_8), URLDecoder.decode(kv[1], StandardCharsets.UTF_8));
            }
        }
        return map;
    }
}
