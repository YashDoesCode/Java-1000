import java.util.*;
public class HashMapResizingTracker {

    private int capacity = 16;
    private float loadFactor = 0.75f;
    private int size = 0;
    private int resizeCount = 0;

    public void addEntry() {
        size++;
        if ((float) size / capacity > loadFactor) {
            capacity *= 2;
            resizeCount++;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getResizeCount() {
        return resizeCount;
    }
}
