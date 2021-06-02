public class LinearSearchRecursion {

    public int search(int[] arr, int target, int idx) { if (idx >= arr.length) return -1;
        if (arr[idx] == target) return idx;
        return search(arr, target, idx + 1);
    };
}
