import java.util.*;
import java.util.concurrent.*;

public class MessageQueueBroker {

    private final Map<String, BlockingQueue<String>> topicQueues = new ConcurrentHashMap<>();

    public void createTopic(String topic) {
        topicQueues.putIfAbsent(topic, new LinkedBlockingQueue<>());
    }

    public void publish(String topic, String message) {
        BlockingQueue<String> queue = topicQueues.get(topic);
        if (queue != null) {
            queue.offer(message);
        }
    }

    public String consume(String topic, long timeoutMs) throws InterruptedException {
        BlockingQueue<String> queue = topicQueues.get(topic);
        if (queue == null) return null;
        return queue.poll(timeoutMs, TimeUnit.MILLISECONDS);
    }

    public int getQueueDepth(String topic) {
        BlockingQueue<String> queue = topicQueues.get(topic);
        return queue == null ? 0 : queue.size();
    }
}
