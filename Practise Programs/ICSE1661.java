
package PractisePrograms;

import java.util.Scanner;

public class ICSE1661 {

    public ICSE1661() {
    }

    public static void main(String[] args) {
        System.out.println("Enter three numbers: ");
        Scanner sc = new Scanner(System.in);
        double a = (double)sc.nextInt();
        double b = (double)sc.nextInt();
        double c = (double)sc.nextInt();
        System.out.println("1/a^2  + 2/b^2 + 3/c^3 = " + (1.0 / Math.pow(a, 2.0) + 2.0 / Math.pow(b, 2.0) + 3.0 / Math.pow(c, 2.0)));
        sc.close();
    }
}
