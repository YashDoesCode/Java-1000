
package PractisePrograms;

import java.util.Scanner;

public class FactorialReciprocalSeries {

    public FactorialReciprocalSeries() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int factorial = 1;

        for(int i = 1; i <= n; ++i) {
            factorial *= i;
            sum += 1 / factorial;
        }

        sc.close();
    }
}
