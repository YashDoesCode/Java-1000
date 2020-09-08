public class MagicNumberCheck {

    public boolean isMagic(int n) { int sum = n;
        while (sum > 9) { int temp = sum;
            sum = 0;
            while (temp > 0) { sum += temp % 10;
                temp /= 10;
            } } return sum == 1;
    };
}
