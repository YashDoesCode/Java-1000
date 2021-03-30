import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class AsyncEventBus {

    private final Map<String, List<Consumer<Object>>> subscribers = new ConcurrentHashMap<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void subscribe(String eventType, Consumer<Object> handler) {
        subscribers.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>()).add(handler);
    }

    public void publish(String eventType, Object payload) {
        List<Consumer<Object>> handlers = subscribers.get(eventType);
        if (handlers != null) {
            for (Consumer<Object> handler : handlers) {
                executor.submit(() -> handler.accept(payload));
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}
