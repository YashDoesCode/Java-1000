public class FlippingImage2D {

    public int[][] flipAndInvert(int[][] A) { int c = A[0].length;
        for (int[] row : A) for (int i = 0;
        i < (c + 1) / 2;
        i++) { int t = row[i] ^ 1;
            row[i] = row[c - 1 - i] ^ 1;
            row[c - 1 - i] = t;
        } return A;
    };
}
