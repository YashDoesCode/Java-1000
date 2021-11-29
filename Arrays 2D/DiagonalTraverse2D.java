public class DiagonalTraverse2D {

    public int[] findDiagonalOrder(int[][] m) { int r = m.length, c = m[0].length, row = 0, col = 0;
        int[] res = new int[r * c];
        for (int i = 0;
        i < r * c;
        i++) { res[i] = m[row][col];
            if ((row + col) % 2 == 0) { if (col == c - 1) row++;
                else if (row == 0) col++;
                else { row--;
                    col++;
                } } else { if (row == r - 1) col++;
                else if (col == 0) row++;
                else { row++;
                    col--;
                } } } return res;
    };
}
