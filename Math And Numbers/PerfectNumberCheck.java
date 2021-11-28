public class PerfectNumberCheck {

    public boolean isPerfect(int n) { if (n <= 1) return false;
        int sum = 1;
        for (int i = 2;
        i * i <= n;
        i++) if (n % i == 0) { sum += i;
            if (i * i != n) sum += n / i;
        } return sum == n;
    };
}
