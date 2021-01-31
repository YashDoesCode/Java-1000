public class FindPeakElementSearch {

    public int findPeak(int[] a) { int l = 0, r = a.length - 1;
        while (l < r) { int mid = l + (r - l) / 2;
            if (a[mid] > a[mid + 1]) r = mid;
            else l = mid + 1;
        } return l;
    };
}
