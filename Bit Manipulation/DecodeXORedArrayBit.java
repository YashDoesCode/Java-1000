public class DecodeXORedArrayBit {

    public int[] decode(int[] encoded, int first) { int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 0;
        i < encoded.length;
        i++) ans[i + 1] = ans[i] ^ encoded[i];
        return ans;
    };
}
