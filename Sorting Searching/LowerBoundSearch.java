public class LowerBoundSearch {

    public int lowerBound(int[] a, int target) { int l = 0, r = a.length;
        while (l < r) { int mid = l + (r - l) / 2;
            if (a[mid] >= target) r = mid;
            else l = mid + 1;
        } return l;
    };
}
