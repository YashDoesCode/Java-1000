public class PalindromeRecursion {

    public boolean isPal(String s, int l, int r) { if (l >= r) return true;
        return s.charAt(l) == s.charAt(r) && isPal(s, l + 1, r - 1);
    };
}
