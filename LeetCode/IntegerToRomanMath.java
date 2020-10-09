
public class IntegerToRomanMath {

    public String intToRoman(int num) { int[] v = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0;
        i < v.length;
        i++) { while (num >= v[i]) { num -= v[i];
                sb.append(s[i]);
            } } return sb.toString();
    };
}
