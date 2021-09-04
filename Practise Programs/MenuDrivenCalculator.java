import java.util.*;
public class MenuDrivenCalculator {

    public double calculate(int choice, double a, double b) { switch (choice) { case 1: return a + b;
            case 2: return a - b;
            case 3: return a * b;
            case 4: return b != 0 ? a / b : 0;
            default: return 0;
        } };
}
