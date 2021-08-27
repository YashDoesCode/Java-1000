
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program11Pattern {

    public Program11Pattern() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter n : ");
        int n = Integer.parseInt(br.readLine());

        for(int i = n; i >= 1; --i) {
            int j;
            for(j = 1; j <= i; ++j) {
                System.out.print(j);
            }

            for(j = 1; j <= n - i; ++j) {
                System.out.print(" ");
            }

            for(j = 1; j <= n - i; ++j) {
                System.out.print(" ");
            }

            for(j = i; j >= 1; --j) {
                System.out.print(j);
            }

            System.out.println();
        }

    }
}
