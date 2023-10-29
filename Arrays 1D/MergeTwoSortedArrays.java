public class MergeTwoSortedArrays {

    public int[] merge(int[] a, int[] b) { int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) res[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    };
}
