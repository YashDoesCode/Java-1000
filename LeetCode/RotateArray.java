
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        rev(nums, 0, n - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, n - 1);
    }

    private void rev(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i]; a[i] = a[j]; a[j] = t;
            i++; j--;
        }
    }
}
