package PractisePrograms;




import java.util.Arrays;
import java.util.Scanner;

public class AlphaBeticalOrPrimeMenuDriven {

    public AlphaBeticalOrPrimeMenuDriven() {
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter 'a' for arranging word lexicographically or 'b' for prime numbers.");
            char choice = sc.next().charAt(0);
            choice = Character.toLowerCase(choice);
            sc.nextLine();
            switch (choice) {
                case 'a':
                System.out.println("Enter a word:");
                String word = sc.nextLine();
                word = word.toUpperCase();
                char[] wordch = word.toCharArray();
                Arrays.sort(wordch);
                String aword = new String(wordch);
                System.out.println(aword);
                break;
                case 'b':
                System.out.println("Enter a number:");
                int n = sc.nextInt();
                System.out.println("Prime numbers from 1 to " + n);


                for(int i = 2; i <= n; ++i) {
                    boolean isPrime = true;

                    for(int j = 2; j <= i / 2; ++j) {
                        if (i % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }

                    if (isPrime) {
                        System.out.println(i);
                    }
                }

                return;
                default:
                System.out.println("Wrong choice");
            }
        }

    }
}
