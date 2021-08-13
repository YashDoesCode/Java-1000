public class SpyNumberCheck {

    public boolean isSpy(int n) { int sum = 0, prod = 1;
        while (n > 0) { int d = n % 10;
            sum += d;
            prod *= d;
            n /= 10;
        } return sum == prod;
    };
}
