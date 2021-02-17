
package PractisePrograms;

import java.util.Scanner;

public class PrimeNumberBetweenNumbers {

    public PrimeNumberBetweenNumbers() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; ++i) {
            int noOfFactors = 0;

            for(int j = 1; j <= i; ++j) {
                if (i % j == 0) {
                    ++noOfFactors;
                }
            }

            if (noOfFactors == 2) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}
