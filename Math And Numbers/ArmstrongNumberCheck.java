public class ArmstrongNumberCheck {

    public boolean isArmstrong(int n) { int orig = n, len = String.valueOf(n).length(), sum = 0;
        while (n > 0) { sum += Math.pow(n % 10, len);
            n /= 10;
        } return sum == orig;
    };
}
