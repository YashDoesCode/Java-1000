import java.util.*;
import java.security.MessageDigest;
public class MiniBlockchain {

    public static class Block {

        public int index;
        public long timestamp;
        public String data;
        public String previousHash;
        public String hash;

        public Block(int index, String data, String previousHash) {
            this.index = index;
            this.timestamp = System.currentTimeMillis();
            this.data = data;
            this.previousHash = previousHash;
            this.hash = calculateHash();
        }

        public String calculateHash() {
            try {
                String input = index + timestamp + data + previousHash;
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

    private List<Block> chain = new ArrayList<>();

    public MiniBlockchain() {
        chain.add(new Block(0, "Genesis Block", "0"));
    }

    public void addBlock(String data) {
        Block prev = chain.get(chain.size() - 1);
        chain.add(new Block(chain.size(), data, prev.hash));
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block cur = chain.get(i), prev = chain.get(i - 1);
            if (!cur.hash.equals(cur.calculateHash())) return false;
            if (!cur.previousHash.equals(prev.hash)) return false;
        }
        return true;
    }
}
