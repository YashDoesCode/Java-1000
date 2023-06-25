public class SudokuSolverRecursion {

    public boolean solveSudoku(char[][] b) { for (int i = 0;
        i < 9;
        i++) for (int j = 0;
        j < 9;
        j++) { if (b[i][j] == '.') { for (char c = '1';
                c <= '9';
                c++) { if (valid(b, i, j, c)) { b[i][j] = c;
                        if (solveSudoku(b)) return true;
                        b[i][j] = '.';
                    } } return false;
            } } return true;
    } private boolean valid(char[][] b, int r, int c, char ch) { for (int i = 0;
        i < 9;
        i++) { if (b[i][c] == ch) return false;
            if (b[r][i] == ch) return false;
            if (b[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == ch) return false;
        } return true;
    };
}
