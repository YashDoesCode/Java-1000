import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceRegistry {

    public static class ServiceInstance {

        public String id;
        public String name;
        public String host;
        public int port;
        public long lastHeartbeat;

        public ServiceInstance(String id, String name, String host, int port) {
            this.id = id;
            this.name = name;
            this.host = host;
            this.port = port;
            this.lastHeartbeat = System.currentTimeMillis();
        }
    }

    private final Map<String, List<ServiceInstance>> registry = new ConcurrentHashMap<>();

    public void register(ServiceInstance instance) {
        registry.computeIfAbsent(instance.name, k -> new ArrayList<>()).add(instance);
    }

    public void heartbeat(String serviceName, String instanceId) {
        List<ServiceInstance> list = registry.get(serviceName);
        if (list != null) {
            for (ServiceInstance inst : list) {
                if (inst.id.equals(instanceId)) {
                    inst.lastHeartbeat = System.currentTimeMillis();
                }
            }
        }
    }

    public List<ServiceInstance> getInstances(String serviceName) {
        return registry.getOrDefault(serviceName, Collections.emptyList());
    }

    public void evictStale(long timeoutMs) {
        long now = System.currentTimeMillis();
        for (List<ServiceInstance> list : registry.values()) {
            list.removeIf(inst -> now - inst.lastHeartbeat > timeoutMs);
        }
    }
}
