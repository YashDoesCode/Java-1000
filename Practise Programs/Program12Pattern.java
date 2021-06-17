
package PractisePrograms;

import java.util.Scanner;

public class Program12Pattern {

    public Program12Pattern() {
    }

    public static void main(String[] args) {
        System.out.println("Enter n: ");
        Scanner ob = new Scanner(System.in);
        int n = ob.nextInt();
        int c = 65;
        int k = n;

        for(int i = 1; i <= n; ++i) {
            int j;
            for(j = 1; j <= i; ++j) {
                System.out.print(i);
            }

            for(j = k; j >= 1; --j) {
                System.out.print((char)c);
            }

            --k;
            ++c;
            System.out.println();
        }

        System.out.println(Math.sqrt(-25.0));
    }
}
