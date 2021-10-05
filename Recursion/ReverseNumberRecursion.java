public class ReverseNumberRecursion {

    public int reverse(int n) { return helper(n, 0);
    } private int helper(int n, int rev) { if (n == 0) return rev;
        return helper(n / 10, rev * 10 + n % 10);
    };
}
