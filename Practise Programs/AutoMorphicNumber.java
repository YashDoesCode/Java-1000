package PractisePrograms;




import java.util.Scanner;

public class AutoMorphicNumber {

    public AutoMorphicNumber() {
    }

    static boolean isAutoMorphic(int n) {
        for(int sq = (int)Math.pow((double)n, 2.0); n > 0; sq /= 10) {
            if (n % 10 != sq % 10) {
                return false;
            }

            n /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        System.out.println(isAutoMorphic(n) ? "Automorphic" : "Not Automorphic");
        sc.close();
    }
}
