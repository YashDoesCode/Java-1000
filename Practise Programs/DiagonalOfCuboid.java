
package PractisePrograms;

import java.util.Scanner;

public class DiagonalOfCuboid {

    public DiagonalOfCuboid() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the length,breadth and height of the cuboid: ");
            int l = sc.nextInt();
            int b = sc.nextInt();
            int h = sc.nextInt();
            DiagonalOfCuboid ob = new DiagonalOfCuboid();
            int r = ob.lengthOfDiagonal(l, b, h);
            System.out.println("Diagonal = " + r + " units");
        } catch (Throwable var8) {
            try {
                sc.close();
            } catch (Throwable var7) {
                var8.addSuppressed(var7);
            }

            throw var8;
        }

        sc.close();
    }

    public int lengthOfDiagonal(int length, int breadth, int height) {
        return (int)Math.sqrt(Math.pow((double)length, 2.0) + Math.pow((double)breadth, 2.0) + Math.pow((double)height, 2.0));
    }
}
