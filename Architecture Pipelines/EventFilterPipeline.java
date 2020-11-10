import java.util.*;
public class EventFilterPipeline {

    public interface Filter {
        boolean filter(String event);
    }

    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter f) {
        filters.add(f);
    }

    public boolean passAll(String event) {
        for (Filter f : filters) {
            if (!f.filter(event)) return false;
        }
        return true;
    }
}
