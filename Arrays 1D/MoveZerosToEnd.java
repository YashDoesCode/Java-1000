public class MoveZerosToEnd {

    public void moveZeros(int[] a) { int j = 0;
        for (int i = 0;
        i < a.length;
        i++) if (a[i] != 0) { int t = a[i];
            a[i] = a[j];
            a[j++] = t;
        } };
}
