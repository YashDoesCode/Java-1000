
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseNumber {

    static int reverse = 0;

    public ReverseNumber(int n) {
        while(n > 0) {
            int d = n % 10;
            n /= 10;
            reverse = reverse * 10 + d;
        }

    }

    int reverseUsingString(int n) {
        String no = String.valueOf(n);
        String rev = "";

        int reverse2;
        for(reverse2 = no.length() - 1; reverse2 >= 0; --reverse2) {
            rev = rev + no.charAt(reverse2);
        }

        reverse2 = Integer.parseInt(rev);
        return reverse2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number : ");
        int n = Integer.parseInt(br.readLine());
        ReverseNumber ob = new ReverseNumber(n);
        int a = ob.reverseUsingString(n);
        if (reverse == a) {
            System.out.println("Reverse of " + n + " is : " + reverse);
        }

    }
}
