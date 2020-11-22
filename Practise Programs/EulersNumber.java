
package PractisePrograms;

import java.util.Scanner;

public class EulersNumber {

    public EulersNumber() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        double sum = 1.0;

        for(int i = 1; i <= n; ++i) {
            int factorial = 1;

            for(int j = 1; j <= i; ++j) {
                factorial *= j;
            }

            sum += 1.0 / (double)factorial;
        }

        System.out.println("e  = " + sum);
        sc.close();
    }
}
