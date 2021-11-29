package PractisePrograms;

import java.util.Scanner;

public class NoOfDigits {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        System.out.println("No of digits = " + (int)(Math.floor(Math.log10(n)+1)));
        sc.close();
    }
}
