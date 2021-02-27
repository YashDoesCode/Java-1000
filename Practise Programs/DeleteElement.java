
package PractisePrograms;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {

    public DeleteElement() {
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] a = new int[50];
            System.out.println("Enter no of elements in array");
            int n = sc.nextInt();
            System.out.println("Enter elements: ");

            int pos;
            for(pos = 0; pos < n; ++pos) {
                a[pos] = sc.nextInt();
            }

            System.out.println("Orignal array: ");
            System.out.println(Arrays.toString(a));
            System.out.println("Enter element's position which is to be deleted");
            pos = sc.nextInt();

            for(int i = pos; i < n; ++i) {
                a[i] = a[i + 1];
            }

            --n;
            System.out.println("Final array: ");
            System.out.print(Arrays.toString(a));
            sc.close();
        }
    }
}
