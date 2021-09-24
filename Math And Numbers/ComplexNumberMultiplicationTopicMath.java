public class ComplexNumberMultiplicationTopicMath {

    public String multiply(String num1, String num2) { String[] a = num1.split("\\+"), b = num2.split("\\+");
        int r1 = Integer.parseInt(a[0]), i1 = Integer.parseInt(a[1].replace("i", ""));
        int r2 = Integer.parseInt(b[0]), i2 = Integer.parseInt(b[1].replace("i", ""));
        int real = r1 * r2 - i1 * i2, img = r1 * i2 + r2 * i1;
        return real + "+" + img + "i";
    };
}
