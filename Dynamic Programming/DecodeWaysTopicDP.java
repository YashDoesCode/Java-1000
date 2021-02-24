public class DecodeWaysTopicDP {

    public int numDecodings(String s) { if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        int n = s.length(), p1 = 1, p2 = 1;
        for (int i = 1;
        i < n;
        i++) { int cur = 0;
            int one = s.charAt(i) - '0', two = Integer.parseInt(s.substring(i - 1, i + 1));
            if (one != 0) cur += p1;
            if (two >= 10 && two <= 26) cur += p2;
            p2 = p1;
            p1 = cur;
        } return p1;
    };
}
