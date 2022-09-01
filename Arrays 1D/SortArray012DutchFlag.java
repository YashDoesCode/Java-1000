public class SortArray012DutchFlag {

    public void sort012(int[] a) { int l = 0, m = 0, r = a.length - 1;
        while (m <= r) { if (a[m] == 0) { int t = a[l];
                a[l++] = a[m];
                a[m++] = t;
            } else if (a[m] == 1) m++;
            else { int t = a[m];
                a[m] = a[r];
                a[r--] = t;
            } } };
}
