
package PractisePrograms;

import java.util.Scanner;

public class MultipleHarshad {

    public MultipleHarshad() {
    }

    static int sumDigits(int n) {
        int temp = n;

        int sum;
        for(sum = 0; temp > 0; temp /= 10) {
            sum += temp % 10;
        }

        return sum;
    }

    static boolean isHarshad(int n) {
        int sum = sumDigits(n);
        return sum != 0 && n % sum == 0;
    }

    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = n / sumDigits(n);
        if (isHarshad(n)) {
            if (isHarshad(r)) {
                System.out.println("" + n + " is a multiple harshad number.");
            } else {
                System.out.println("" + n + " is not a multiple harshad number.");
            }
        } else {
            System.out.println("" + n + " is not a harshad number.");
        }

    }
}
