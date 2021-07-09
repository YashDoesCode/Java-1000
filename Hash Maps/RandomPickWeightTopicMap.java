import java.util.*;
public class RandomPickWeightTopicMap {

    private int[] p;

    private Random rand = new Random();

    public RandomPickWeightTopicMap(int[] w) { p = new int[w.length];
        p[0] = w[0];
        for (int i = 1;
        i < w.length;
        i++) p[i] = p[i - 1] + w[i];
    } public int pickIndex() { int target = rand.nextInt(p[p.length - 1]) + 1;
        int idx = Arrays.binarySearch(p, target);
        return idx >= 0 ? idx : -idx - 1;
    };
}
