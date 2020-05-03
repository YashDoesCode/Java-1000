package PractisePrograms;

import java.util.Scanner;

public class NoOfTrailingZeroes {

    static int trailingZeroes(int n){
        int s = 0;
        for(int i = 1;i<=n;i*=5)
        s+=n/i;
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        System.out.println(n+" factorial has "+ trailingZeroes(n)+" trailing Zeroes.");
        sc.close();
    }
}
