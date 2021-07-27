
package PractisePrograms;

import java.util.Scanner;

public class Area {

    public Area() {
    }

    public static int areaSquare(int s) {
        return (int)Math.sqrt((double)s);
    }

    public static int perimeterSquare(int s) {
        return 4 * s;
    }

    public static int areaRectangle(int l, int b) {
        return l * b;
    }

    public static int perimeterRectangle(int l, int b) {
        return 2 * (l + b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side: ");
        int s = sc.nextInt();
        int area = areaSquare(s);
        int perimeter = perimeterSquare(s);
        System.out.println("Area = " + area);
        System.out.println("Perimeter = " + perimeter);
        System.out.println("Enter length and breadth: ");
        int l = sc.nextInt();
        int b = sc.nextInt();
        int area2 = areaRectangle(l, b);
        int perimeter2 = perimeterRectangle(l, b);
        System.out.println("Area of rectangle : " + area2);
        System.out.println("Perimeter of rectangle: " + perimeter2);
        sc.close();
    }
}
