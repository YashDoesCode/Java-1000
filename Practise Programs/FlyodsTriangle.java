
package PractisePrograms;

import java.util.Scanner;

public class FlyodsTriangle {

    public FlyodsTriangle() {
    }

    public static void main(String[] args) {
        System.out.println("Enter number of rows :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= i; ++j) {
                System.out.print("" + count + " ");
                ++count;
            }

            System.out.println();
        }

        sc.close();
    }
}
