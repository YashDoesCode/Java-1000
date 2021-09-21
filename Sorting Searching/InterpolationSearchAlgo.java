public class InterpolationSearchAlgo {

    public int search(int[] a, int target) { int l = 0, r = a.length - 1;
        while (l <= r && target >= a[l] && target <= a[r]) { if (l == r) return a[l] == target ? l : -1;
            int pos = l + (((r - l) / (a[r] - a[l])) * (target - a[l]));
            if (a[pos] == target) return pos;
            if (a[pos] < target) l = pos + 1;
            else r = pos - 1;
        } return -1;
    };
}
