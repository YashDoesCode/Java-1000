
package PractisePrograms;

public class BitwiseOperators {

    public BitwiseOperators() {
    }

    public static void main(String[] args) {
        int p = 9;
        int q = 10;
        System.out.println("9 | 10 : " + (p | q));
        System.out.println("9 | 10: " + (p & q));
        System.out.println("9^10: " + (p ^ q));
        System.out.println("~9: " + ~p);
        System.out.println("9<<10: " + (p << q));
        System.out.println("9<<2: " + (p << 2));
        System.out.println("9>>10: " + (p >> 10));
        System.out.println("9>>1:" + (p >> 1));
    }
}
