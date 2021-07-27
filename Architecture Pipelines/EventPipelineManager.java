import java.util.*;
public class EventPipelineManager {

    public interface EventStage {
        String process(String eventData);
    }

    private List<EventStage> pipeline = new ArrayList<>();

    public void addStage(EventStage stage) {
        pipeline.add(stage);
    }

    public String executePipeline(String initialData) {
        String currentData = initialData;
        for (EventStage stage : pipeline) {
            currentData = stage.process(currentData);
        }
        return currentData;
    }
}
