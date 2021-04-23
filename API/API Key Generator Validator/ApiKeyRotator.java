import java.util.*;
import java.security.SecureRandom;

public class ApiKeyRotator {

    private final Map<String, Long> keyStore = new HashMap<>();
    private final SecureRandom random = new SecureRandom();
    private final long ttlMs;

    public ApiKeyRotator(long ttlMs) {
        this.ttlMs = ttlMs;
    }

    public String generateKey(String clientId) {
        byte[] bytes = new byte[24];
        random.nextBytes(bytes);
        String key = clientId + "_" + Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        keyStore.put(key, System.currentTimeMillis() + ttlMs);
        return key;
    }

    public boolean validateKey(String key) {
        Long exp = keyStore.get(key);
        if (exp == null) return false;
        if (System.currentTimeMillis() > exp) {
            keyStore.remove(key);
            return false;
        }
        return true;
    }

    public void rotateKey(String oldKey, String clientId) {
        keyStore.remove(oldKey);
        generateKey(clientId);
    }

    public void purgeExpired() {
        long now = System.currentTimeMillis();
        keyStore.entrySet().removeIf(entry -> now > entry.getValue());
    }

    public int activeKeyCount() {
        purgeExpired();
        return keyStore.size();
    }
}
