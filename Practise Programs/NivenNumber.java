
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NivenNumber {

    public NivenNumber() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        int sumOfDigits = sum(n);
        if (n % sumOfDigits == 0) {
            System.out.println("The number is niven.");
        } else {
            System.out.println("The number is not niven.");
        }

    }

    public static int sum(int n) {
        int sum;
        for(sum = 0; n % 10 > 0; n /= 10) {
            int digit = n % 10;
            sum += digit;
        }

        return sum;
    }
}
