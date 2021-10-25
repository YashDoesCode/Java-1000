public class CountVowelsPermutationTopicDP {

    public int countVowelsPermutation(int n) { long MOD = 1000000007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int k = 1;
        k < n;
        k++) { long aNext = (e + i + u) % MOD;
            long eNext = (a + i) % MOD;
            long iNext = (e + o) % MOD;
            long oNext = i;
            long uNext = (i + o) % MOD;
            a = aNext;
            e = eNext;
            i = iNext;
            o = oNext;
            u = uNext;
        } return (int) ((a + e + i + o + u) % MOD);
    };
}
