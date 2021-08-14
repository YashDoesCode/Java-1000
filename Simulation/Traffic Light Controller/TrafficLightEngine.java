public class TrafficLightEngine {

    public enum Light { RED, YELLOW, GREEN }
    private Light currentLight = Light.RED;

    public void changeLight(Light newLight) {
        this.currentLight = newLight;
    }

    public Light getCurrentLight() {
        return currentLight;
    }
}
