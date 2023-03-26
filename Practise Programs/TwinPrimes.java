
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwinPrimes {

    public TwinPrimes() {
    }

    boolean isPrime(int n) {
        int count = 0;

        for(int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                ++count;
            }
        }

        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter two numbers : ");
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        TwinPrimes ob = new TwinPrimes();
        if (ob.isPrime(a) && ob.isPrime(b) && Math.abs(b - a) == 2) {
            System.out.println("" + a + " and " + b + " are twin primes.");
        } else {
            System.out.println("They are not twin primes.");
        }

    }
}
