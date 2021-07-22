import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class QueryUrlEncoder {

    public String encodeQueryParam(String param) {
        if (param == null) return "";
        return URLEncoder.encode(param, StandardCharsets.UTF_8);
    }
}
