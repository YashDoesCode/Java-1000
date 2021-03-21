import java.util.*;
import java.util.concurrent.*;
public class AsyncEventPublisher {

    public interface EventListener {
        void onEvent(String event);
    }

    private List<EventListener> listeners = new CopyOnWriteArrayList<>();

    private ExecutorService executor = Executors.newCachedThreadPool();

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void publish(String event) {
        for (EventListener listener : listeners) {
            executor.submit(() -> listener.onEvent(event));
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}
