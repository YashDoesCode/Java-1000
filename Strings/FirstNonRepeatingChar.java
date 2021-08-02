public class FirstNonRepeatingChar {

    public char firstNonRepeating(String s) { int[] cnt = new int[256];
        for (char c : s.toCharArray()) cnt[c]++;
        for (char c : s.toCharArray()) if (cnt[c] == 1) return c;
        return ' ';
    };
}
