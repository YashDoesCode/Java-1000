public class TokenValidator {

    public boolean validateTokenFormat(String token) {
        if (token == null || token.length() < 16) return false;
        return token.matches("^[a-zA-Z0-9_-]+$");
    }
}
