package PractisePrograms;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArmstrongNumber {

    public ArmstrongNumber() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        int sum = sumOfCubesOfDigits(n);
        if (n == sum) {
            System.out.println("The number is armstrong.");
        } else {
            System.out.println("The number is not armstrong.");
        }

    }

    public static int sumOfCubesOfDigits(int n) {
        int sum;
        for(sum = 0; n % 10 > 0; n /= 10) {
            int digit = n % 10;
            sum = (int)((double)sum + Math.pow((double)digit, 3.0));
        }

        return sum;
    }
}
