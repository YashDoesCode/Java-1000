public class FractionAdditionMath {

    public int[] addFractions(int n1, int d1, int n2, int d2) { int num = n1 * d2 + n2 * d1;
        int den = d1 * d2;
        int g = gcd(num, den);
        return new int[]{num / g, den / g};
    } private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b);
    };
}
