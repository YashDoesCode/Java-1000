public class AdditiveNumberRecursion {

    public boolean isAdditiveNumber(String num) { int n = num.length();
        for (int i = 1;
        i <= n / 2;
        i++) { for (int j = 1;
            Math.max(i, j) <= n - i - j;
            j++) { if (valid(i, j, num)) return true;
            } } return false;
    } private boolean valid(int i, int j, String num) { if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        long n1 = Long.parseLong(num.substring(0, i));
        long n2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j;
        start < num.length();
        start += sum.length()) { n2 = n2 + n1;
            n1 = n2 - n1;
            sum = Long.toString(n2);
            if (!num.startsWith(sum, start)) return false;
        } return true;
    };
}
