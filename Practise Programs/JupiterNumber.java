
package PractisePrograms;

import java.util.Scanner;

public class JupiterNumber {

    public JupiterNumber() {
    }

    static boolean isJupiter(int n) {
        int a = n;
        int lastdigit = n % 10;

        int firstdigit;
        for(firstdigit = 0; a > 0; a /= 10) {
            firstdigit = a % 10;
        }

        return n % (firstdigit + lastdigit) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        if (isJupiter(n)) {
            System.out.println("The number is a jupiter number.");
        } else {
            System.out.println("The number is not a jupiter number.");
        }

    }
}
