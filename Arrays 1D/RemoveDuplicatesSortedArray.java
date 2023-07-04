public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] a) { if (a.length == 0) return 0;
        int j = 0;
        for (int i = 1;
        i < a.length;
        i++) if (a[i] != a[j]) a[++j] = a[i];
        return j + 1;
    };
}
