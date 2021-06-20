
package PractisePrograms;

import java.util.Scanner;

public class IncreasingDecreasingPattern {

    public IncreasingDecreasingPattern() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n ");
        int n = sc.nextInt();

        for(int i = 0; i < 2 * n; ++i) {
            int col = i > n ? 2 * n - i - 1 : i;

            for(int j = 0; j < col; ++j) {
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
