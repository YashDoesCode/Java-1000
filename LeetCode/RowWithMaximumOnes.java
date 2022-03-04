
public class RowWithMaximumOnes {

    public int[] rowAndMaximumOnes(int[][] mat) { int r = mat.length, c = mat[0].length;
        int maxR = 0, maxCnt = -1;
        for (int i = 0;
        i < r;
        i++) { int cnt = 0;
            for (int j = 0;
            j < c;
            j++) cnt += mat[i][j];
            if (cnt > maxCnt) { maxCnt = cnt;
                maxR = i;
            } } return new int[]{maxR, maxCnt};
    };
}
