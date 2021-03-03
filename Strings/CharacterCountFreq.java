public class CharacterCountFreq {

    public int[] countCharFreq(String s) { int[] cnt = new int[256];
        for (char c : s.toCharArray()) cnt[c]++;
        return cnt;
    };
}
