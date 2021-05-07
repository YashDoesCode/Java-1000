public class SearchInsertPosition {

    public int searchInsert(int[] a, int target) { int l = 0, r = a.length - 1;
        while (l <= r) { int mid = l + (r - l) / 2;
            if (a[mid] == target) return mid;
            if (a[mid] < target) l = mid + 1;
            else r = mid - 1;
        } return l;
    };
}
