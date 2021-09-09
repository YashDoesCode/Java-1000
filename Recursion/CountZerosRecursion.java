public class CountZerosRecursion {

    public int countZeros(int n) { if (n == 0) return 1;
        return helper(n);
    } private int helper(int n) { if (n == 0) return 0;
        return (n % 10 == 0 ? 1 : 0) + helper(n / 10);
    };
}
