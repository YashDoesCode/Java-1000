package PractisePrograms;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AreaOfTriangle {

    static double area;
    static double side;
    static double a;
    static double b;
    static double c;
    static double s;

    public AreaOfTriangle() {
    }

    public double areaOfIsosceles() throws IOException {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the two sides: ");
        a = (double)Integer.parseInt(ob.readLine());
        b = (double)Integer.parseInt(ob.readLine());
        area = b / 4.0 * Math.sqrt(4.0 * a * a - b * b);
        return area;
    }

    public static double areaOfEquilateral() throws IOException {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the side: ");
        side = (double)Integer.parseInt(ob.readLine());
        area = Math.sqrt(3.0) / 4.0 * Math.pow(side, 2.0);
        return area;
    }

    public static double areaOfScalene() throws IOException {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the three sides: ");
        a = (double)Integer.parseInt(ob.readLine());
        b = (double)Integer.parseInt(ob.readLine());
        c = (double)Integer.parseInt(ob.readLine());
        s = (a + b + c) / 2.0;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the type of triangle(e for equilateral, i for isosceles and s for scalene) ");
        char t = (char)ob.read();
        AreaOfTriangle a = new AreaOfTriangle();
        switch (t) {
            case 'e':
            area = areaOfEquilateral();
            break;
            case 'i':
            area = a.areaOfIsosceles();
            break;
            case 's':
            area = areaOfScalene();
        }

        System.out.println("Area of triangle =  " + area + " units.");
    }
}
