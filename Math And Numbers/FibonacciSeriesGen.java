public class FibonacciSeriesGen {

    public int[] generate(int n) { int[] fib = new int[n];
        if (n > 0) fib[0] = 0;
        if (n > 1) fib[1] = 1;
        for (int i = 2;
        i < n;
        i++) fib[i] = fib[i - 1] + fib[i - 2];
        return fib;
    };
}
