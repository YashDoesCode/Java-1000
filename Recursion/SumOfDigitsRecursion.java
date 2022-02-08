public class SumOfDigitsRecursion {

    public int sumDigits(int n) { return n == 0 ? 0 : n % 10 + sumDigits(n / 10);
    };
}
