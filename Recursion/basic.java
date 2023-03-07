package Recursion;
import java.util.Scanner;

public class basic {

    static int sumSeries(int n){
        if(n==0) return 0;
        return sumSeries(n-1)+n;
    }
    static int sumAlternateSeries(int n){
        if(n==0) return 0;
        if(n%2==1) return sumAlternateSeries(n-1)+n;
        else return sumAlternateSeries(n-1)-n;
    }
    static void printMultiples(int n, int k){
        if(k==1){
            System.out.println(n);
            return;
        }
        printMultiples(n, k-1);
        System.out.println(n*k);
    }
    static void printIncreasing(int n){
        if(n==1)
        {
            System.out.println(n);
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
    static void printDecreasing(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
    static int fibonacci(int n){
        if(n==0 || n==1)
        return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        printIncreasing(n);
        printDecreasing(n);
        printMultiples(n, n);
        System.out.println(sumSeries(n));
        System.out.println(sumAlternateSeries(n));
        sc.close();
    }
}
