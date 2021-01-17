public class TernarySearchAlgo {

    public int search(int[] a, int target) { int l = 0, r = a.length - 1;
        while (l <= r) { int m1 = l + (r - l) / 3, m2 = r - (r - l) / 3;
            if (a[m1] == target) return m1;
            if (a[m2] == target) return m2;
            if (target < a[m1]) r = m1 - 1;
            else if (target > a[m2]) l = m2 + 1;
            else { l = m1 + 1;
                r = m2 - 1;
            } } return -1;
    };
}
