public class SumArrayRecursion {

    public int sum(int[] arr, int idx) { if (idx >= arr.length) return 0;
        return arr[idx] + sum(arr, idx + 1);
    };
}
