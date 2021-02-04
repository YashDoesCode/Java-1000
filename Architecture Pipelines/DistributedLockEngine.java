import java.util.concurrent.ConcurrentHashMap;

public class DistributedLockEngine {

    private final ConcurrentHashMap<String, String> locks = new ConcurrentHashMap<>();

    public boolean acquireLock(String resource, String owner) {
        return locks.putIfAbsent(resource, owner) == null;
    }

    public boolean releaseLock(String resource, String owner) {
        return locks.remove(resource, owner);
    }
}
