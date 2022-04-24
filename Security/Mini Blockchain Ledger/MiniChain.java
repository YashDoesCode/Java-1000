import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MiniChain {

    public static class Transaction {

        private String sender;
        private String recipient;
        private double amount;
        private long timestamp;

        public Transaction(String sender, String recipient, double amount) {
            this.sender = sender;
            this.recipient = recipient;
            this.amount = amount;
            this.timestamp = System.currentTimeMillis();
        }

        public String getSender() {
            return sender;
        }

        public String getRecipient() {
            return recipient;
        }

        public double getAmount() {
            return amount;
        }

        public String calculateHash() {
            String data = sender + ":" + recipient + ":" + amount + ":" + timestamp;
            return applySha256(data);
        }
    }

    public static class Block {

        private int index;
        private long timestamp;
        private List<Transaction> transactions;
        private String previousHash;
        private String hash;
        private int nonce;

        public Block(int index, List<Transaction> transactions, String previousHash) {
            this.index = index;
            this.timestamp = System.currentTimeMillis();
            this.transactions = new ArrayList<>(transactions);
            this.previousHash = previousHash;
            this.nonce = 0;
            this.hash = calculateBlockHash();
        }

        public String calculateBlockHash() {
            StringBuilder sb = new StringBuilder();
            sb.append(index).append(timestamp).append(previousHash).append(nonce);
            for (Transaction tx : transactions) {
                sb.append(tx.calculateHash());
            }
            return applySha256(sb.toString());
        }

        public void mineBlock(int difficulty) {
            String target = new String(new char[difficulty]).replace('\0', '0');
            while (!hash.substring(0, difficulty).equals(target)) {
                nonce++;
                hash = calculateBlockHash();
            }
        }

        public String getHash() {
            return hash;
        }

        public String getPreviousHash() {
            return previousHash;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }
    }

    private List<Block> chain = new ArrayList<>();

    private List<Transaction> pendingTransactions = new ArrayList<>();
    private int difficulty = 2;

    public MiniChain() {
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        List<Transaction> genesisTxs = new ArrayList<>();
        genesisTxs.add(new Transaction("System", "GenesisAccount", 1000.0));
        Block genesisBlock = new Block(0, genesisTxs, "0");
        genesisBlock.mineBlock(difficulty);
        chain.add(genesisBlock);
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addTransaction(Transaction tx) {
        if (tx.getAmount() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
        pendingTransactions.add(tx);
    }

    public void minePendingTransactions(String minerAddress) {
        pendingTransactions.add(new Transaction("System", minerAddress, 10.0));
        Block block = new Block(chain.size(), pendingTransactions, getLatestBlock().getHash());
        block.mineBlock(difficulty);
        chain.add(block);
        pendingTransactions.clear();
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateBlockHash())) {
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    private static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
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
