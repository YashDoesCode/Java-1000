import java.security.SecureRandom;
public class ApiKeyGeneratorValidator {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private SecureRandom random = new SecureRandom();

    public String generateKey(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        return sb.toString();
    }

    public boolean validateKey(String key, int expectedLen) {
        return key != null && key.length() == expectedLen && key.matches("[A-Za-z0-9]+");
    }
}
