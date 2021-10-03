public class PowerRecursion {

    public double power(double x, int n) { if (n == 0) return 1;
        double half = power(x, n / 2);
        return n % 2 == 0 ? half * half : (n > 0 ? x * half * half : (half * half) / x);
    };
}
