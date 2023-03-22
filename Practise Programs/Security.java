
package PractisePrograms;

import java.util.Scanner;

public class Security {

    String n;
    int h;
    double r;
    double w;

    public Security() {
    }

    void get() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name, rate and number of hours worked:");
        this.n = sc.nextLine();
        this.r = sc.nextDouble();
        this.h = sc.nextInt();
    }

    void calWage() {
        if (this.h <= 40) {
            this.w = this.r * 40.0;
        } else if (40 < this.h && this.h <= 60) {
            this.w = 1.5 * (double)(this.h - 40) * this.r + 40.0 * this.r;
        } else if (60 < this.h && this.h <= 80) {
            this.w = (double)((this.h - 60) * 2) * this.r + 30.0 * this.r + 40.0 * this.r;
        }

    }

    void display() {
        System.out.println("Name\t\tHours\t\tWages\t");
        System.out.println(this.n + "\t\t" + this.h + "\t\t" + this.w);
    }

    public static void main(String[] args) {
        Security personnel = new Security();
        personnel.get();
        personnel.calWage();
        personnel.display();
    }
}
