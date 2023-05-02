import java.util.*;

public class ChainLedgerTree {

    private final List<String> blocks = new ArrayList<>();

    public void addBlock(String blockHash) {
        blocks.add(blockHash);
    }

    public int getChainLength() {
        return blocks.size();
    }
}
