public class SortColorsTopic {

    public void sortColors(int[] nums) { int l = 0, m = 0, r = nums.length - 1;
        while (m <= r) { if (nums[m] == 0) swap(nums, l++, m++);
            else if (nums[m] == 1) m++;
            else swap(nums, m, r--);
        } } private void swap(int[] a, int i, int j) { int t = a[i];
        a[i] = a[j];
        a[j] = t;
    };
}
