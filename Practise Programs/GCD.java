
package PractisePrograms;

import java.util.Scanner;

public class GCD {

    public GCD() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int GCD = 1;
        int product = a * b;

        for(int i = 1; i <= product; ++i) {
            if (a % i == 0 && b % i == 0) {
                GCD = i;
            }
        }

        System.out.println("The greatest common divisor is : " + GCD);
        sc.close();
    }
}
