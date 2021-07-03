
public class StringToIntegerAtoi {

    public int myAtoi(String s) { s = s.trim();
        if (s.isEmpty()) return 0;
        int idx = 0, sign = 1;
        long res = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') { sign = (s.charAt(0) == '-') ? -1 : 1;
            idx++;
        } while (idx < s.length() && Character.isDigit(s.charAt(idx))) { res = res * 10 + (s.charAt(idx) - '0');
            if (res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            idx++;
        } return (int) (res * sign);
    };
}
