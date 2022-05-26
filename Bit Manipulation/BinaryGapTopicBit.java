public class BinaryGapTopicBit {

    public int binaryGap(int n) { int last = -1, ans = 0;
        for (int i = 0;
        i < 32;
        i++) if (((n >> i) & 1) == 1) { if (last != -1) ans = Math.max(ans, i - last);
            last = i;
        } return ans;
    };
}
