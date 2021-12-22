public class SplitArrayLargestSumSearch {

    public int splitArray(int[] nums, int k) { int l = 0, r = 0;
        for (int n : nums) { l = Math.max(l, n);
            r += n;
        } while (l < r) { int mid = l + (r - l) / 2, count = 1, sum = 0;
            for (int n : nums) { if (sum + n > mid) { count++;
                    sum = n;
                } else sum += n;
            } if (count > k) l = mid + 1;
            else r = mid;
        } return l;
    };
}
