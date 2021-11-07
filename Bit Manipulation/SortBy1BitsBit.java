import java.util.*;
public class SortBy1BitsBit {

    public int[] sortByBits(int[] arr) { Integer[] a = new Integer[arr.length];
        for (int i = 0;
        i < arr.length;
        i++) a[i] = arr[i];
        Arrays.sort(a, (x, y) -> { int c1 = Integer.bitCount(x), c2 = Integer.bitCount(y);
            return c1 != c2 ? Integer.compare(c1, c2) : Integer.compare(x, y);
        });
        for (int i = 0;
        i < arr.length;
        i++) arr[i] = a[i];
        return arr;
    };
}
