public class HarshadNumberCheck {

    public boolean isHarshad(int n) { int sum = 0, temp = n;
        while (temp > 0) { sum += temp % 10;
            temp /= 10;
        } return n % sum == 0;
    };
}
