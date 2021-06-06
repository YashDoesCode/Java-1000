
package PractisePrograms;

import java.util.Scanner;

public class Program10Pattern {

    public Program10Pattern() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                if (j <= i) {
                    System.out.print("" + i + " ");
                } else {
                    System.out.print("" + j + " ");
                }
            }

            System.out.println();
        }

    }
}
