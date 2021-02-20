
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XylemNumber {

    public XylemNumber() {
    }

    static boolean isXylem(int n) {
        int sumMeans = 0;
        int sumExtremes = 0;
        String s = String.valueOf(n);
        int extreme1 = Integer.parseInt(Character.toString(s.charAt(s.length() - 1)));
        int extreme2 = Integer.parseInt(Character.toString(s.charAt(0)));
        sumExtremes += extreme1 + extreme2;

        for(int i = 1; i < s.length() - 1; ++i) {
            sumMeans += Integer.parseInt(Character.toString(s.charAt(i)));
        }

        return sumMeans == sumExtremes;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Entera  number");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (isXylem(n)) {
            System.out.println("Xylem number");
        } else {
            System.out.println("Phloem Number");
        }

    }
}
