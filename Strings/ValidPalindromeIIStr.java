public class ValidPalindromeIIStr {

    public boolean validPalindrome(String s) { int l = 0, r = s.length() - 1;
        while (l < r) { if (s.charAt(l) != s.charAt(r)) return isPal(s, l + 1, r) || isPal(s, l, r - 1);
            l++;
            r--;
        } return true;
    } private boolean isPal(String s, int l, int r) { while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    };
}
