public class RotateArrayRight {

    public void rotate(int[] a, int k) { k %= a.length;
        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
    } private void reverse(int[] a, int l, int r) { while (l < r) { int t = a[l];
            a[l++] = a[r];
            a[r--] = t;
        } };
}
