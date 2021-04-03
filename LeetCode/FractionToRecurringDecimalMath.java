
import java.util.*;
public class FractionToRecurringDecimalMath {

    public String fractionToDecimal(int numerator, int denominator) { if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        long n = Math.abs((long) numerator), d = Math.abs((long) denominator);
        sb.append(n / d);
        long rem = n % d;
        if (rem == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> mp = new HashMap<>();
        while (rem != 0) { if (mp.containsKey(rem)) { sb.insert(mp.get(rem), "(");
                sb.append(")");
                break;
            } mp.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / d);
            rem %= d;
        } return sb.toString();
    };
}
