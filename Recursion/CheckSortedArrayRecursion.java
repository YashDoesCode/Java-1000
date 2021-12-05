public class CheckSortedArrayRecursion {

    public boolean isSorted(int[] arr, int idx) { if (idx >= arr.length - 1) return true;
        return arr[idx] <= arr[idx + 1] && isSorted(arr, idx + 1);
    };
}
