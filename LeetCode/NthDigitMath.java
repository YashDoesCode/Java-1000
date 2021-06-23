
public class NthDigitMath {

    public int findNthDigit(int n) { int len = 1;
        long count = 9, start = 1;
        while (n > len * count) { n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        } start += (n - 1) / len;
        String s = Long.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    };
}
