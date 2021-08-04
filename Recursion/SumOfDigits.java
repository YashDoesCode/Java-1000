package Recursion;

import java.util.Scanner;

public class SumOfDigits {

    public static int sumOfDigits(int n){
        if(n%10==0)
        return n;
        int sum = 0;
        sum += sumOfDigits(n/10) + n%10;
        return sum;
    }
    static int countOfDigits(int n){
        if(n>=1 && n<=9)
        return 1;
        return countOfDigits(n/10) + 1;
    }
    static int power(int x, int y){
        if(y==1)
        return x;
        return power(x,y-1)*x ;
    }
    static int power2(int x, int y){
        if(y==0)
        return 1;
        int smallpow = power2(x, y/2);
        if(y%2==0)
        return smallpow*smallpow;
        else
        return smallpow*smallpow*x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        System.out.println(sumOfDigits(n));
        System.out.println(countOfDigits(n));
        System.out.println("Enter two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c =   power(a, b);
        System.out.println(c);
        sc.close();
    }
}
