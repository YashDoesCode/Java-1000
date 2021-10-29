public class SelectionSortAlgo {

    public void sort(int[] a) { int n = a.length;
        for (int i = 0;
        i < n - 1;
        i++) { int minIdx = i;
            for (int j = i + 1;
            j < n;
            j++) if (a[j] < a[minIdx]) minIdx = j;
            int t = a[minIdx];
            a[minIdx] = a[i];
            a[i] = t;
        } };
}
