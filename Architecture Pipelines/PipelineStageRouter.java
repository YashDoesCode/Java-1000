import java.util.*;

public class PipelineStageRouter {

    private final List<String> stages = new ArrayList<>();

    public void addStage(String stageName) {
        stages.add(stageName);
    }

    public List<String> getPipelineStages() {
        return Collections.unmodifiableList(stages);
    }
}
