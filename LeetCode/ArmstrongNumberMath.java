
public class ArmstrongNumberMath {

    public boolean isArmstrong(int n) { int orig = n, digits = String.valueOf(n).length(), sum = 0;
        while (n > 0) { sum += Math.pow(n % 10, digits);
            n /= 10;
        } return sum == orig;
    };
}
