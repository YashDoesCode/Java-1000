
public class ComplexNumberMultiplicationMath {

    public String complexNumberMultiply(String num1, String num2) { int[] a = parse(num1), b = parse(num2);
        int real = a[0] * b[0] - a[1] * b[1];
        int img = a[0] * b[1] + a[1] * b[0];
        return real + "+" + img + "i";
    } private int[] parse(String s) { String[] parts = s.split("\\+");
        int real = Integer.parseInt(parts[0]);
        int img = Integer.parseInt(parts[1].replace("i", ""));
        return new int[]{real, img};
    };
}
