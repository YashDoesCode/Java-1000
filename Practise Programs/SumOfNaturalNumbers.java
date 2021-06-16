
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNaturalNumbers {

    public SumOfNaturalNumbers() {
    }

    public int sum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a natural number: ");
        int n = Integer.parseInt(ob.readLine());
        if (n < 1) {
            System.out.println("Enter a natural number(>=1).");
            System.exit(0);
        }

        int sum = 0;

        for(int i = 1; i <= n; ++i) {
            sum += i;
        }

        System.out.println(sum);
        SumOfNaturalNumbers ob2 = new SumOfNaturalNumbers();
        int sum2 = ob2.sum(n);
        System.out.println(sum2);
    }
}
