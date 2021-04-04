import java.util.Scanner;

public class ShashiTravels {

    public ShashiTravels() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] names = new String[15];
        int[] amounts = new int[15];

        int i;
        for(i = 0; i <= 5; ++i) {
            System.out.print("Enter Customer " + (i + 1) + " Name: ");
            names[i] = in.nextLine();
            System.out.print("Enter Customer " + (i + 1) + " Ticket Charges: ");
            amounts[i] = in.nextInt();
            in.nextLine();
        }

        System.out.println("Sl. No.\tName\t\tTicket Charges\tDiscount\t\tNet Amount");

        for(i = 0; i < 5; ++i) {
            int dp = 0;
            int amt = amounts[i];

            if (amt > 70000) {
                dp = 18;
            } else if (amt >= 55001) {
                dp = 16;
            } else if (amt >= 35001) {
                dp = 12;
            } else if (amt >= 25001) {
                dp = 10;
            } else {
                dp = 2;
            }

            double disc = (double)(amt * dp) / 100.0;
            double net = (double)amt - disc;
            System.out.println(i + 1 + "\t" + names[i] + "\t" + amounts[i] + "\t\t" + disc + "\t\t" + net);
        }

        in.close();
    }
}
