public class BinarySearchRecursion {

    public int search(int[] arr, int target, int l, int r) { if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] > target) return search(arr, target, l, mid - 1);
        return search(arr, target, mid + 1, r);
    };
}
