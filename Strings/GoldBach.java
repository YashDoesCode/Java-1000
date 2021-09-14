package Strings;

import java.util.Scanner;

public class GoldBach {

    static boolean isPrime(int n){
        boolean res = true;
        for(int i = 2; i<=Math.sqrt(n);i++){
            if(n%i==0) res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an even integer between (9,50):");
        int n = sc.nextInt();
        if((n>9 && n<50) && n%2==0){
            for(int i = 2; i<=n;i++){
                for(int j = i;j<=n;j++){
                    if(i+j==n && (isPrime(i)&&isPrime(j)&&(i%2==1 && j%2==1)))
                    System.out.println("Prime pairs : "+ i+","+j);
                }
            }
        }
        else
        System.out.println("Invalid input.");

        sc.close();
    }
}
