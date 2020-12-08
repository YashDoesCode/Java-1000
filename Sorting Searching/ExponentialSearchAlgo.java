import java.util.*;
public class ExponentialSearchAlgo {

    public int search(int[] a, int target) { if (a[0] == target) return 0;
        int i = 1;
        while (i < a.length && a[i] <= target) i *= 2;
        return Arrays.binarySearch(a, i / 2, Math.min(i, a.length), target);
    };
}
