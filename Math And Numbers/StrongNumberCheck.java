public class StrongNumberCheck {

    public boolean isStrong(int n) { int orig = n, sum = 0;
        while (n > 0) { sum += fact(n % 10);
            n /= 10;
        } return sum == orig;
    } private int fact(int x) { int f = 1;
        for (int i = 1;
        i <= x;
        i++) f *= i;
        return f;
    };
}
