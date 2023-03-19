

import java.util.Scanner;

public class ISC2015 {

    public static int sumOfDigits(long n){
        int temp = (int)n,sum=0;
        while(temp!=0){
            int d= temp%10;
            sum+=d;
            temp/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter M and N : ");
            int m = sc.nextInt();
            int n = sc.nextInt();
            if((m>=100 && n<=10000) && (n>0 && n<=100)){
                long i = m;
                while(sumOfDigits(i)!=n){
                    i++;
                }
                System.out.println("Required No = " +i);
                System.out.println("No of digits = "+(""+i).length());
                return;
            }
            else
            System.out.println("Invalid input.");
            sc.close();
        }
    }
}
