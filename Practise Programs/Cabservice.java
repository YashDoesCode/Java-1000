
package PractisePrograms;

import java.util.Scanner;

public class Cabservice {

    String taxino = "";
    String name = "";
    int d = 0;
    int amount;

    Cabservice() {
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the taxi number, name and distance travelled (in km)");
        this.taxino = sc.nextLine();
        this.name = sc.nextLine();
        this.d = sc.nextInt();
        sc.close();
    }

    void calculate() {
        int rate = 0;
        if (this.d <= 1) {
            rate = 25;
        } else if (this.d >= 1 && this.d <= 5) {
            rate = 30;
        } else if (this.d >= 5 && this.d <= 10) {
            rate = 35;
        } else if (this.d >= 10 && this.d <= 20) {
            rate = 40;
        } else if (this.d >= 20) {
            rate = 40;
        }

        this.amount = this.d * rate;
    }

    void display() {
        System.out.println("Taxino\tName\t\tDistance(km)\tBill amount");
        System.out.println(this.taxino + "\t" + this.name + "\t" + this.d + "\t\t" + this.amount);
    }

    public static void main(String[] args) {
        Cabservice ob = new Cabservice();
        ob.input();
        ob.calculate();
        ob.display();
    }
}
