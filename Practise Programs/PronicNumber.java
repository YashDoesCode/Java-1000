
package PractisePrograms;

import java.util.Scanner;

public class PronicNumber {

    public PronicNumber() {
    }

    static boolean isPronic(int n) {
        for(int i = 1; i < n; ++i) {
            if (i * (i + 1) == n) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        if (isPronic(n)) {
            System.out.println("" + n + " is a Pronic number.");
        } else {
            System.out.println("" + n + " is not a Pronic number.");
        }

    }
}
