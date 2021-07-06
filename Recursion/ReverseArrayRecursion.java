public class ReverseArrayRecursion {

    public void reverse(int[] arr, int l, int r) { if (l >= r) return;
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
        reverse(arr, l + 1, r - 1);
    };
}
