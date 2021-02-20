public class KaprekarNumberCheck {

    public boolean isKaprekar(int n) { if (n == 1) return true;
        long sq = (long) n * n;
        String s = String.valueOf(sq);
        int len = s.length();
        for (int i = 1;
        i < len;
        i++) { long l = Long.parseLong(s.substring(0, i));
            long r = Long.parseLong(s.substring(i));
            if (r > 0 && l + r == n) return true;
        } return false;
    };
}
