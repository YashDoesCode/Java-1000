
package PractisePrograms;

import java.util.Scanner;

public class BitManipulation {

    public BitManipulation() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        double bitMask = (double)((int)number & 1);
        String result = bitMask == 0.0 ? "Number is even" : "Number is odd";
        System.out.println(result);
        sc.close();
    }
}
