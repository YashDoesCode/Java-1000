import java.security.MessageDigest;
import java.util.*;

public class MerkleTreeLedger {

    public String getMerkleRoot(List<String> transactions) {
        if (transactions == null || transactions.isEmpty()) return "";
        List<String> temp = new ArrayList<>(transactions);
        while (temp.size() > 1) {
            if (temp.size() % 2 != 0) {
                temp.add(temp.get(temp.size() - 1));
            }
            List<String> newLevel = new ArrayList<>();
            for (int i = 0; i < temp.size(); i += 2) {
                String combined = temp.get(i) + temp.get(i + 1);
                newLevel.add(sha256(combined));
            }
            temp = newLevel;
        }
        return temp.get(0);
    }

    private String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
