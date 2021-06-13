import java.security.MessageDigest;
public class ProofOfWorkMiner {

    public String mineBlock(int difficulty, String data) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        int nonce = 0;
        while (true) {
            String hash = calculateHash(data + nonce);
            if (hash.substring(0, difficulty).equals(target)) return hash;
            nonce++;
        }
    }

    private String calculateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
