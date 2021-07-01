public class ShellSortAlgo {

    public void sort(int[] a) { int n = a.length;
        for (int gap = n / 2;
        gap > 0;
        gap /= 2) for (int i = gap;
        i < n;
        i++) { int temp = a[i], j = i;
            while (j >= gap && a[j - gap] > temp) { a[j] = a[j - gap];
                j -= gap;
            } a[j] = temp;
        } };
}
