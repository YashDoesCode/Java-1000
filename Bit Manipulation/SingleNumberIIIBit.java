public class SingleNumberIIIBit {

    public int[] singleNumber(int[] nums) { int diff = 0;
        for (int n : nums) diff ^= n;
        diff &= -diff;
        int[] res = new int[2];
        for (int n : nums) if ((n & diff) == 0) res[0] ^= n;
        else res[1] ^= n;
        return res;
    };
}
