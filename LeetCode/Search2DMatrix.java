
public class Search2DMatrix {

    public boolean searchMatrix(int[][] m, int target) { if (m.length == 0) return false;
        int r = m.length, c = m[0].length;
        int l = 0, h = r * c - 1;
        while (l <= h) { int mid = l + (h - l) / 2;
            int val = m[mid / c][mid % c];
            if (val == target) return true;
            if (val < target) l = mid + 1;
            else h = mid - 1;
        } return false;
    };
}
