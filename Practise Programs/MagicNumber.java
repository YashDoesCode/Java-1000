
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicNumber {

    public MagicNumber() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        int temp = n;

        int sum;
        for(sum = 0; temp > 0 || sum > 9; temp /= 10) {
            if (temp == 0) {
                temp = sum;
                sum = 0;
            }

            sum += temp % 10;
        }

        if (sum == 1) {
            System.out.println("" + n + " is a magical number.");
        } else {
            System.out.println("" + n + " is not a magical number,");
        }

    }
}
