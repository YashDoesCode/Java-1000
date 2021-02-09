import java.util.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class ConsistentHashRing {

    private final TreeMap<Long, String> circle = new TreeMap<>();
    private final int numberOfReplicas;

    public ConsistentHashRing(int numberOfReplicas, List<String> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        for (String node : nodes) {
            addNode(node);
        }
    }

    public void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hash(node + "-" + i), node);
        }
    }

    public String getNode(String key) {
        if (circle.isEmpty()) return null;
        long hash = hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Long, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private long hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes(StandardCharsets.UTF_8));
            return ((long) (digest[3] & 0xFF) << 24) |
                   ((long) (digest[2] & 0xFF) << 16) |
                   ((long) (digest[1] & 0xFF) << 8) |
                   ((long) (digest[0] & 0xFF));
        } catch (Exception e) {
            return key.hashCode();
        }
    }
}
