public class SystemSimulatorEngine {

    private int tickCount = 0;

    public void tick() {
        tickCount++;
    }

    public int getTicks() {
        return tickCount;
    }
}
