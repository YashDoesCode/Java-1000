public class MergeSortRecursion {

    public void mergeSort(int[] a, int l, int r) { if (l < r) { int mid = l + (r - l) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, mid, r);
        } } private void merge(int[] a, int l, int m, int r) { int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0;
        i < n1;
        i++) L[i] = a[l + i];
        for (int j = 0;
        j < n2;
        j++) R[j] = a[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) a[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    };
}
