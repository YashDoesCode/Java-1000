import java.util.*;
public class OAuthValidator {

    public static class TokenInfo {

        String token;
        String scope;
        long expiresAt;
        boolean revoked;

        public TokenInfo(String token, String scope, long ttlMs) {
            this.token = token;
            this.scope = scope;
            this.expiresAt = System.currentTimeMillis() + ttlMs;
            this.revoked = false;
        }
    }

    private Map<String, TokenInfo> tokenStore = new HashMap<>();

    public void registerToken(String token, String scope, long ttlMs) {
        tokenStore.put(token, new TokenInfo(token, scope, ttlMs));
    }

    public boolean isTokenValid(String token, String requiredScope) {
        TokenInfo info = tokenStore.get(token);
        if (info == null || info.revoked) return false;
        if (System.currentTimeMillis() > info.expiresAt) return false;
        return info.scope != null && info.scope.contains(requiredScope);
    }

    public void revokeToken(String token) {
        TokenInfo info = tokenStore.get(token);
        if (info != null) info.revoked = true;
    }
}
