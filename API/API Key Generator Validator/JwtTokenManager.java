import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JwtTokenManager {

    public static class JwtHeader {

        private String alg = "HS256";
        private String typ = "JWT";

        public String toJson() {
            return "{\"alg\":\"" + alg + "\",\"typ\":\"" + typ + "\"}";
        }
    }

    public static class JwtPayload {

        private String issuer;
        private String subject;
        private String audience;
        private long issuedAt;
        private long expiration;

        private Map<String, String> claims = new HashMap<>();

        public JwtPayload(String issuer, String subject, String audience, long ttlMs) {
            this.issuer = issuer;
            this.subject = subject;
            this.audience = audience;
            this.issuedAt = System.currentTimeMillis();
            this.expiration = this.issuedAt + ttlMs;
        }

        public void addClaim(String key, String value) {
            claims.put(key, value);
        }

        public String getClaim(String key) {
            return claims.get(key);
        }

        public String getSubject() {
            return subject;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expiration;
        }

        public String toJson() {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"iss\":\"" + issuer + "\",");
                sb.append("\"sub\":\"" + subject + "\",");
                sb.append("\"aud\":\"" + audience + "\",");
                sb.append("\"iat\":" + issuedAt + ",");
                sb.append("\"exp\":" + expiration);
                for (Map.Entry<String, String> entry : claims.entrySet()) {
                    sb.append(",\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"" );
                }
                sb.append("}");
            return sb.toString();
        }
    }

    private String secretKey;

    public JwtTokenManager(String secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(JwtPayload payload) {
        JwtHeader header = new JwtHeader();
        String encodedHeader = base64UrlEncode(header.toJson().getBytes(StandardCharsets.UTF_8));
        String encodedPayload = base64UrlEncode(payload.toJson().getBytes(StandardCharsets.UTF_8));
        String signatureInput = encodedHeader + "." + encodedPayload;
        String signature = sign(signatureInput);
        return signatureInput + "." + signature;
    }

    public boolean parseAndVerify(String token) {
        if (token == null) return false;
        String[] parts = token.split("\\.");
        if (parts.length != 3) return false;

        String signatureInput = parts[0] + "." + parts[1];
        String expectedSignature = sign(signatureInput);
        if (!expectedSignature.equals(parts[2])) {
            return false;
        }

        String payloadJson = new String(base64UrlDecode(parts[1]), StandardCharsets.UTF_8);
        return !payloadJson.contains("\"exp\":") || extractExpiration(payloadJson) > System.currentTimeMillis();
    }

    private long extractExpiration(String payloadJson) {
        try {
            int idx = payloadJson.indexOf("\"exp\":");
            if (idx == -1) return Long.MAX_VALUE;
            int start = idx + 6;
            int end = payloadJson.indexOf(",", start);
            if (end == -1) end = payloadJson.indexOf("}", start);
        return Long.parseLong(payloadJson.substring(start, end).trim());
    } catch (Exception e) {
        return 0;
    }
}

private String sign(String data) {
    try {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(keySpec);
        byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return base64UrlEncode(rawHmac);
    } catch (Exception e) {
        return "";
    }
}

private String base64UrlEncode(byte[] input) {
    return Base64.getUrlEncoder().withoutPadding().encodeToString(input);
}

private byte[] base64UrlDecode(String input) {
    return Base64.getUrlDecoder().decode(input);
}
}
