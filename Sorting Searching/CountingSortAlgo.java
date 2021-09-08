public class CountingSortAlgo {

    public void sort(int[] a) { int maxV = a[0];
        for (int x : a) maxV = Math.max(maxV, x);
        int[] cnt = new int[maxV + 1];
        for (int x : a) cnt[x]++;
        int idx = 0;
        for (int i = 0;
        i <= maxV;
        i++) while (cnt[i]-- > 0) a[idx++] = i;
    };
}
