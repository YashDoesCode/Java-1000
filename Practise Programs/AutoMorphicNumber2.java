
package PractisePrograms;

import java.util.Scanner;

public class AutoMorphicNumber2 {

    public AutoMorphicNumber2() {
    }

    static boolean isAutomorphic(int n) {
        for(int sq = n * n; n > 0; sq /= 10) {
            if (sq % 10 != n % 10) {
                return false;
            }

            n /= 10;
        }

        return true;
    }

    static boolean isAutomorphic2(int n) {
        int sq = n * n;
        int temp = n;

        int d;
        for(d = 0; temp > 0; temp /= 10) {
            ++d;
        }

        int extractedNo = sq % (int)Math.pow(10.0, (double)d);
        return n == extractedNo;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a number :");
            int n = sc.nextInt();
            if (isAutomorphic2(n)) {
                System.out.println("" + n + " is an automorphic number.");
            } else {
                System.out.println("" + n + " is not an automorphic number.");
            }
        }

    }
}
