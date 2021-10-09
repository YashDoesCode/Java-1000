
package PractisePrograms;

import java.util.Scanner;

public class DecreasingLargePyramidPattern {

    public DecreasingLargePyramidPattern() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; ++i) {
            int j;
            for(j = 1; j <= n - i; ++j) {
                System.out.print("");
            }

            for(j = n; j >= 2 * i - 1; --j) {
                System.out.print("*");
            }

            System.out.println();
        }

        sc.close();
    }
}
