public class QuickSortRecursion {

    public void quickSort(int[] a, int l, int r) { if (l < r) { int p = partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        } } private int partition(int[] a, int l, int r) { int pivot = a[r], i = l - 1;
        for (int j = l;
        j < r;
        j++) { if (a[j] < pivot) { i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            } } int t = a[i + 1];
        a[i + 1] = a[r];
        a[r] = t;
        return i + 1;
    };
}
