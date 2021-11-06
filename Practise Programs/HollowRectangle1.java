
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HollowRectangle1 {

    public HollowRectangle1() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter rows and columns: ");
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if (i != 1 && i != m && j != 1 && j != n) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            System.out.println();
        }

    }
}
