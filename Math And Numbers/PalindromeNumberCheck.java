public class PalindromeNumberCheck {

    public boolean isPal(int n) { if (n < 0) return false;
        int orig = n, rev = 0;
        while (n > 0) { rev = rev * 10 + n % 10;
            n /= 10;
        } return rev == orig;
    };
}
