
package PractisePrograms;

import java.util.Scanner;

public class superSpyNumber {

    public superSpyNumber() {
    }

    int sumOfDigits(int n) {
        int sum;
        for(sum = 0; n > 0; n /= 10) {
            sum += n % 10;
        }

        return sum;
    }

    int noOfDigits(int n) {
        int no;
        for(no = 0; n > 0; ++no) {
            n /= 10;
        }

        return no;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        superSpyNumber ob = new superSpyNumber();
        if (ob.sumOfDigits(n) == ob.noOfDigits(n)) {
            System.out.println("" + n + " is a super spy number.");
        } else {
            System.out.println("" + n + " is not a super spy number.");
        }

    }
}
