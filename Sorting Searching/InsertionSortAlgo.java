public class InsertionSortAlgo {

    public void sort(int[] a) { int n = a.length;
        for (int i = 1;
        i < n;
        i++) { int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) { a[j + 1] = a[j];
                j--;
            } a[j + 1] = key;
        } };
}
