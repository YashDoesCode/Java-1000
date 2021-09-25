
package PractisePrograms;

import java.util.Scanner;

public class SpecialNumber {

    public SpecialNumber() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int sum = 0;
        int fact = 1;

        for(int m = n; m % 10 > 0; m /= 10) {
            for(int i = 1; i <= m % 10; ++i) {
                fact *= i;
            }

            sum += fact;
            fact = 1;
        }

        if (sum == n) {
            System.out.println("The number is special.");
        } else {
            System.out.println("The number is not special.");
        }

        sc.close();
    }
}
