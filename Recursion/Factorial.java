package Recursion;

public class Factorial {

    static int fact(int n){
        if(n==0)
        return 1;
        return n*fact(n-1);
    }

    public static void main(String[] args) {
        System.out.println(fact(9));
        int a = 7 ,b=2;
        System.out.println("value :"+a+b);
        System.out.println("value : "+ (a+b));
    }
}
