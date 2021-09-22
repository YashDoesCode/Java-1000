
package PractisePrograms;

import java.util.Scanner;

public class DistanceBetweenTwoPoints {

    public DistanceBetweenTwoPoints() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinates of first point: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println("Enter coordinates of second point: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        double distance = Math.sqrt(Math.pow((double)(y2 - y1), 2.0) + Math.pow((double)(x2 - x1), 2.0));
        System.out.println("Distance between points =  " + distance);
        sc.close();
    }
}
