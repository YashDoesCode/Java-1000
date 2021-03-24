
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreatestNumberFormedBy3Digits {

    static int greatest1;
    static int greatest2;
    static int greatest3;
    static int no;

    public GreatestNumberFormedBy3Digits() {
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader ob = new InputStreamReader(System.in);
        BufferedReader ob2 = new BufferedReader(ob);
        System.out.println("Enter three digits between 1 and 9: ");
        int a = Integer.parseInt(ob2.readLine());
        int b = Integer.parseInt(ob2.readLine());
        int c = Integer.parseInt(ob2.readLine());
        if (a > b && a > c) {
            greatest1 = a;
            if (b > c) {
                greatest2 = b;
                greatest3 = c;
            } else {
                greatest2 = c;
                greatest3 = b;
            }
        }

        if (b > a && b > c) {
            greatest1 = b;
            if (a > c) {
                greatest2 = a;
                greatest3 = c;
            } else {
                greatest2 = c;
                greatest3 = a;
            }
        }

        if (c > a && c > b) {
            greatest1 = c;
            if (a > b) {
                greatest2 = a;
                greatest3 = b;
            } else {
                greatest2 = b;
                greatest3 = a;
            }
        }

        int var10001 = 100 * greatest1 + 10 * greatest2;
        System.out.println("Greatest Number = " + (var10001 + greatest3));
        var10001 = 100 * greatest3 + 10 * greatest2;
        System.out.println("Smallest Number = " + (var10001 + greatest1));
    }
}
