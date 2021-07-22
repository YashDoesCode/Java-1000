
public class SortColors {

    public void sortColors(int[] nums) {
        int l = 0, mid = 0, r = nums.length - 1;
        while (mid <= r) {
            if (nums[mid] == 0) swap(nums, l++, mid++);
            else if (nums[mid] == 1) mid++;
            else swap(nums, mid, r--);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
