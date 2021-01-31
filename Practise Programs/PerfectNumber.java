
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectNumber {

    public PerfectNumber() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        int sum = sumOfFactors(n);
        if (n == sum) {
            System.out.println("The number is perfect.");
        } else {
            System.out.println("The number is not perfect.");
        }

    }

    public static int sumOfFactors(int n) {
        int i = 1;

        int sum;
        for(sum = 0; i < n; ++i) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
