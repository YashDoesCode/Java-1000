
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HappyNumber {

    public HappyNumber() {
    }

    static int sumOfSqDigits(int n) {
        int sum;
        for(sum = 0; n != 0; n /= 10) {
            int d = n % 10;
            sum += d * d;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        br.close();

        int temp;
        for(temp = n; temp > 9; temp = sumOfSqDigits(temp)) {
        }

        if (temp == 1) {
            System.out.println("" + n + " is a Happy number.");
        } else {
            System.out.println("" + n + " is not a Happy number.");
        }

    }
}
