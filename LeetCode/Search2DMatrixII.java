
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] m, int target) { int r = 0, c = m[0].length - 1;
        while (r < m.length && c >= 0) { if (m[r][c] == target) return true;
            else if (m[r][c] > target) c--;
            else r++;
        } return false;
    };
}
