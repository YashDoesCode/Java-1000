import java.util.*;
public class OAuthClientCredentialsManager {

    public static class Client {

        String clientId;
        String clientSecret;
        String scopes;

        public Client(String id, String secret, String scopes) {
            this.clientId = id;
            this.clientSecret = secret;
            this.scopes = scopes;
        }
    }

    private Map<String, Client> clients = new HashMap<>();

    public void registerClient(String id, String secret, String scopes) {
        clients.put(id, new Client(id, secret, scopes));
    }

    public boolean authenticate(String id, String secret) {
        Client c = clients.get(id);
        return c != null && c.clientSecret.equals(secret);
    }

    public String getClientScopes(String id) {
        Client c = clients.get(id);
        return c != null ? c.scopes : "";
    }
}
