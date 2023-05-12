package PractisePrograms;

import java.util.Scanner;

public class Bits {

    static int getBit(int n, int pos){
        int bitMask = 1<<pos;
        if((bitMask&n)==0) return 0;
        return 1;
    }
    static int setBit(int n, int pos){
        int bitMask = 1<<pos;
        return (bitMask|n);
    }
    static int clearBit(int n, int pos){
        int bitMask = 1<<pos;
        bitMask  = ~(bitMask);
        return (n&bitMask);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter pos : ");
        int i = sc.nextInt();
        System.out.println(getBit(n, i));
        System.out.println(setBit(n, i));
        System.out.println(clearBit(n, i));
        sc.close();
    }
}
