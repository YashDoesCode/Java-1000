import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class ServiceLoadBalancerSim {

    private List<String> serverPool = new ArrayList<>();

    private AtomicInteger currentIndex = new AtomicInteger(0);

    public void addServer(String serverIp) {
        serverPool.add(serverIp);
    }

    public String getNextServer() {
        if (serverPool.isEmpty()) return null;
        int idx = Math.abs(currentIndex.getAndIncrement()) % serverPool.size();
        return serverPool.get(idx);
    }
}
