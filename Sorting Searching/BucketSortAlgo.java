import java.util.*;
public class BucketSortAlgo {

    public void sort(float[] a) { int n = a.length;
        List<Float>[] b = new List[n];
        for (int i = 0;
        i < n;
        i++) b[i] = new ArrayList<>();
        for (float x : a) b[(int) (n * x)].add(x);
        for (int i = 0;
        i < n;
        i++) Collections.sort(b[i]);
        int idx = 0;
        for (int i = 0;
        i < n;
        i++) for (float x : b[i]) a[idx++] = x;
    };
}
