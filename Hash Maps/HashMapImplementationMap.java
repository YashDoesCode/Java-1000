import java.util.*;
public class HashMapImplementationMap {

    private int[] a = new int[1000001];

    public HashMapImplementationMap() { Arrays.fill(a, -1);
    } public void put(int key, int value) { a[key] = value;
    } public int get(int key) { return a[key];
    } public void remove(int key) { a[key] = -1;
    };
}
