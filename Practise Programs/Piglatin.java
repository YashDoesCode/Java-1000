
package PractisePrograms;

import java.util.Scanner;

public class Piglatin {

    String wd = "";

    Piglatin() {
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        this.wd = sc.nextLine();
    }

    void display() {
        String finalWord = "";
        this.wd.toUpperCase();
        int temp = 0;

        for(int i = 0; i < this.wd.length(); ++i) {
            if (this.wd.charAt(i) == 'a' || this.wd.charAt(i) == 'e' || this.wd.charAt(i) == 'i' || this.wd.charAt(i) == 'o' || this.wd.charAt(i) == 'u') {
                finalWord = finalWord + this.wd.charAt(i);
                temp = i;
                break;
            }
        }

        finalWord = finalWord + this.wd.substring(temp) + this.wd.substring(0, temp) + "AY";
        System.out.println(finalWord);
    }

    public static void main(String[] args) {
        Piglatin ob = new Piglatin();
        ob.input();
        ob.display();
    }
}
