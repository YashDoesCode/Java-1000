
public class GreatestCommonDivisorMath {

    public int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b);
    } public int lcm(int a, int b) { return (a / gcd(a, b)) * b;
    };
}
