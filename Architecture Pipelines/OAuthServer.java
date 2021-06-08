import java.util.*;
import java.security.SecureRandom;

public class OAuthServer {

    public static class ClientApp {

        private String clientId;
        private String clientSecret;
        private String redirectUri;
        private Set<String> allowedScopes;

        public ClientApp(String clientId, String clientSecret, String redirectUri, Set<String> allowedScopes) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.redirectUri = redirectUri;
            this.allowedScopes = allowedScopes;
        }

        public String getClientId() {
            return clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public String getRedirectUri() {
            return redirectUri;
        }

        public Set<String> getAllowedScopes() {
            return allowedScopes;
        }
    }

    public static class AuthorizationCode {

        private String code;
        private String clientId;
        private String redirectUri;
        private String scope;
        private long expiresAt;

        public AuthorizationCode(String code, String clientId, String redirectUri, String scope, long ttlMs) {
            this.code = code;
            this.clientId = clientId;
            this.redirectUri = redirectUri;
            this.scope = scope;
            this.expiresAt = System.currentTimeMillis() + ttlMs;
        }

        public String getCode() {
            return code;
        }

        public String getClientId() {
            return clientId;
        }

        public String getRedirectUri() {
            return redirectUri;
        }

        public String getScope() {
            return scope;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expiresAt;
        }
    }

    public static class TokenResponse {

        private String accessToken;
        private String refreshToken;
        private String tokenType;
        private long expiresIn;
        private String scope;

        public TokenResponse(String accessToken, String refreshToken, String tokenType, long expiresIn, String scope) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
            this.tokenType = tokenType;
            this.expiresIn = expiresIn;
            this.scope = scope;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public String getScope() {
            return scope;
        }
    }

    private Map<String, ClientApp> clientRegistry = new HashMap<>();

    private Map<String, AuthorizationCode> codeStore = new HashMap<>();

    private Map<String, String> accessTokenStore = new HashMap<>();

    private Map<String, String> refreshTokenStore = new HashMap<>();

    public void registerClient(String clientId, String clientSecret, String redirectUri, Set<String> scopes) {
        clientRegistry.put(clientId, new ClientApp(clientId, clientSecret, redirectUri, scopes));
    }

    public String issueAuthorizationCode(String clientId, String redirectUri, String requestedScope) {
        ClientApp app = clientRegistry.get(clientId);
        if (app == null || !app.getRedirectUri().equals(redirectUri)) {
            throw new IllegalArgumentException("Invalid client or redirect URI");
        }
        String code = UUID.randomUUID().toString().replace("-", "");
        AuthorizationCode authCode = new AuthorizationCode(code, clientId, redirectUri, requestedScope, 600000);
        codeStore.put(code, authCode);
        return code;
    }

    public TokenResponse exchangeCodeForToken(String code, String clientId, String clientSecret, String redirectUri) {
        ClientApp app = clientRegistry.get(clientId);
        if (app == null || !app.getClientSecret().equals(clientSecret)) {
            throw new SecurityException("Client authentication failed");
        }
        AuthorizationCode authCode = codeStore.remove(code);
        if (authCode == null || authCode.isExpired() || !authCode.getClientId().equals(clientId)) {
            throw new IllegalArgumentException("Invalid or expired authorization code");
        }
        if (!authCode.getRedirectUri().equals(redirectUri)) {
            throw new IllegalArgumentException("Redirect URI mismatch");
        }

        String accessToken = "access_" + UUID.randomUUID().toString().replace("-", "");
        String refreshToken = "refresh_" + UUID.randomUUID().toString().replace("-", "");

        accessTokenStore.put(accessToken, authCode.getScope());
        refreshTokenStore.put(refreshToken, clientId);

        return new TokenResponse(accessToken, refreshToken, "Bearer", 3600, authCode.getScope());
    }

    public boolean validateAccessToken(String accessToken, String requiredScope) {
        String scope = accessTokenStore.get(accessToken);
        if (scope == null) return false;
        return scope.contains(requiredScope);
    }

    public void revokeToken(String token) {
        accessTokenStore.remove(token);
        refreshTokenStore.remove(token);
    }
}
