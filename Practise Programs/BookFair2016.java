
package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookFair2016 {

    String bName = "";
    double price = 0.0;

    BookFair2016() {
    }

    void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the book name and price: ");
        this.bName = br.readLine();
        this.price = Double.parseDouble(br.readLine());
        br.close();
    }

    void display(double p) {
        System.out.println("Book name : " + this.bName);
        System.out.println("Price(after discout): " + p);
    }

    void calculate() {
        double finalPrice;
        if (this.price <= 1000.0) {
            finalPrice = this.price - 0.02 * this.price;
        } else if (this.price > 1000.0 & this.price <= 3000.0) {
            finalPrice = this.price - 0.1 * this.price;
        } else {
            finalPrice = this.price - 0.15 * this.price;
        }

        this.display(finalPrice);
    }

    public static void main(String[] args) {
        BookFair2016 customer = new BookFair2016();

        try {
            customer.input();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        customer.calculate();
    }
}
