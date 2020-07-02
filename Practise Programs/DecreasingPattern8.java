
package PractisePrograms;

import java.util.Scanner;

public class DecreasingPattern8 {

    public DecreasingPattern8() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();

        for(int i = n; i >= 1; --i) {
            for(int j = 1; j <= 2 * i - 1; ++j) {
                System.out.print(j);
            }

            System.out.println();
        }

        sc.close();
    }
}
