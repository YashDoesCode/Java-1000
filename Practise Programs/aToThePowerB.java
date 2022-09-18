
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aToThePowerB {

    public aToThePowerB() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the base and exponent: ");
        int a = Integer.parseInt(ob.readLine());
        int b = Integer.parseInt(ob.readLine());
        int result = 1;

        for(int i = 1; i <= b; ++i) {
            result *= a;
        }

        System.out.println(result);
    }
}
