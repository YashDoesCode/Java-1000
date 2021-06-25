import java.util.*;

public class EventStoreStream {

    private final List<String> events = new ArrayList<>();

    public synchronized void appendEvent(String eventData) {
        events.add(eventData);
    }

    public synchronized List<String> readEvents() {
        return new ArrayList<>(events);
    }
}
