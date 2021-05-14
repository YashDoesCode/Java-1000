public class SquareRootNewtonMethod {

    public double sqrt(double n) { double x = n, root;
        while (true) { root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 1e-7) break;
            x = root;
        } return root;
    };
}
