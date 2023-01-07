public class SingleNumThree {

    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int n : nums) bitmask ^= n;
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int n : nums) {
            if ((n & diff) != 0) x ^= n;
        }
        return new int[]{x, bitmask ^ x};
    }
}
