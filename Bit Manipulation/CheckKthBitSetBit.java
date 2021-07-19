public class CheckKthBitSetBit {

    public boolean isKthBitSet(int n, int k) { return (n & (1 << k)) != 0;
    };
}
