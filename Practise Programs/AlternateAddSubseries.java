
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternateAddSubseries {

    public AlternateAddSubseries() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter n: ");
        int n = Integer.parseInt(ob.readLine());
        int sum = 0;

        for(int i = 1; i <= n; ++i) {
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
