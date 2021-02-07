public class SearchSortedMatrix2D {

    public boolean search(int[][] m, int target) { int r = 0, c = m[0].length - 1;
        while (r < m.length && c >= 0) { if (m[r][c] == target) return true;
            if (m[r][c] > target) c--;
            else r++;
        } return false;
    };
}
