
package PractisePrograms;

import java.util.Scanner;

public class SimultaneousPrimes {

    public SimultaneousPrimes() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to start from: ");
        int startNumber = scanner.nextInt();
        scanner.close();
        int count = 0;

        for(int number = startNumber; count < 20; ++number) {
            if (isPrime(number)) {
                if (count > 0) {
                    System.out.print(", ");
                }

                System.out.print(number);
                ++count;
            }
        }

    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else {
            for(int i = 2; (double)i <= Math.sqrt((double)num); ++i) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
