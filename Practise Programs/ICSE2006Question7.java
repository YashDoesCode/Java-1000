
package PractisePrograms;

import java.util.Scanner;

public class ICSE2006Question7 {

    public ICSE2006Question7() {
    }

    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("ln " + number + " = " + Math.log((double)number));
        System.out.println("|" + number + "| = " + Math.abs(number));
        System.out.println("\u221a" + number + " = " + Math.sqrt((double)number));
        System.out.println("" + number + "^3 = " + Math.pow((double)number, 3.0));
        System.out.println("Random numbers between 0 and 1 : " + Math.random());
        System.out.println("Random numbers between 0 and 100: " + 100.0 * Math.random());
        sc.close();
    }
}
