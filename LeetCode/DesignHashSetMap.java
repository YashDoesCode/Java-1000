
import java.util.*;
public class DesignHashSetMap {

    private boolean[] b = new boolean[1000001];

    public void add(int key) { b[key] = true;
    } public void remove(int key) { b[key] = false;
    } public boolean contains(int key) { return b[key];
    };
}
