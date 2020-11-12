import java.util.Arrays;
import java.util.Scanner;

public class VampireNumber {

    public VampireNumber() {
    }

    static int noOfDigits(int n) {
        int count = 0;

        for(int temp = n; temp != 0; temp /= 10) {
            int d = temp % 10;
            ++count;
        }

        return count;
    }

    static boolean check(int a, int f1, int f2) {
        boolean flag = true;
        if (f1 != 0 && f2 != 0) {
            String s1 = String.valueOf(f1);
            String s2 = String.valueOf(f2);
            String s = s1.concat(s2);
            String orignal = String.valueOf(a);
            char[] oa = orignal.toCharArray();
            if (s1.length() == s2.length() && s2.length() == orignal.length() / 2) {
                char[] c = s.toCharArray();
                Arrays.sort(c);
                Arrays.sort(oa);

                for(int i = 0; i < c.length; ++i) {
                    if (c[i] == oa[i]) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }

        return flag;
    }

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int a = sc.nextInt();
        if (noOfDigits(a) % 2 == 0) {
            for(int i = 2; (double)i <= Math.sqrt((double)a); ++i) {
                if (a % i == 0) {
                    int f2 = a / i;
                    if (check(a, i, f2)) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("" + a + " is a vampire no.");
        } else {
            System.out.println("" + a + " is not a vampire no.");
        }

    }
}
