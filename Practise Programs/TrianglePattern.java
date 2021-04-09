
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrianglePattern {

    public TrianglePattern() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter n: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i;
        int j;
        for(i = 1; i <= n; ++i) {
            for(j = 1; j <= i; ++j) {
                System.out.print("*");
            }

            System.out.println(" ");
        }

        System.out.println(" ");

        for(i = 1; i <= n; ++i) {
            for(j = n; j >= i; --j) {
                System.out.print("*");
            }

            System.out.println(" ");
        }

    }
}
