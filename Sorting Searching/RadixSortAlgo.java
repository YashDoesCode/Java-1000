import java.util.*;
public class RadixSortAlgo {

    public void sort(int[] a) { int maxV = a[0];
        for (int x : a) maxV = Math.max(maxV, x);
        for (int exp = 1;
        maxV / exp > 0;
        exp *= 10) countSort(a, exp);
    } private void countSort(int[] a, int exp) { int n = a.length;
        int[] output = new int[n], cnt = new int[10];
        for (int x : a) cnt[(x / exp) % 10]++;
        for (int i = 1;
        i < 10;
        i++) cnt[i] += cnt[i - 1];
        for (int i = n - 1;
        i >= 0;
        i--) { output[cnt[(a[i] / exp) % 10] - 1] = a[i];
            cnt[(a[i] / exp) % 10]--;
        } System.arraycopy(output, 0, a, 0, n);
    };
}
