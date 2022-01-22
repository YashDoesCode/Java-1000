import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordSalt {

    private static final int DEFAULT_SALT_BYTES = 16;
    private static final int DEFAULT_HASH_BYTES = 32;
    private static final int DEFAULT_ITERATIONS = 10000;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    public static class HashedPassword {

        private final String hashBase64;
        private final String saltBase64;
        private final int iterations;

        public HashedPassword(String hashBase64, String saltBase64, int iterations) {
            this.hashBase64 = hashBase64;
            this.saltBase64 = saltBase64;
            this.iterations = iterations;
        }

        public String getHashBase64() {
            return hashBase64;
        }

        public String getSaltBase64() {
            return saltBase64;
        }

        public int getIterations() {
            return iterations;
        }

        public String toFormattedString() {
            return iterations + ":" + saltBase64 + ":" + hashBase64;
        }
    }

    public HashedPassword hashPassword(char[] password) throws Exception {
        return hashPassword(password, generateSalt(DEFAULT_SALT_BYTES), DEFAULT_ITERATIONS);
    }

    public HashedPassword hashPassword(char[] password, byte[] salt, int iterations) throws Exception {
        KeySpec spec = new PBEKeySpec(password, salt, iterations, DEFAULT_HASH_BYTES * 8);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] hash = factory.generateSecret(spec).getEncoded();

        String saltStr = Base64.getEncoder().encodeToString(salt);
        String hashStr = Base64.getEncoder().encodeToString(hash);

        return new HashedPassword(hashStr, saltStr, iterations);
    }

    public boolean verifyPassword(char[] password, String formattedHashedPassword) throws Exception {
        String[] parts = formattedHashedPassword.split(":");
        if (parts.length != 3) return false;

        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = Base64.getDecoder().decode(parts[1]);
        byte[] expectedHash = Base64.getDecoder().decode(parts[2]);

        KeySpec spec = new PBEKeySpec(password, salt, iterations, expectedHash.length * 8);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] actualHash = factory.generateSecret(spec).getEncoded();

        return slowEquals(expectedHash, actualHash);
    }

    public byte[] generateSalt(int length) {
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    private boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
}
