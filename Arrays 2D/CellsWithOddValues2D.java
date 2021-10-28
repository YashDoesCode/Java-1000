public class CellsWithOddValues2D {

    public int oddCells(int m, int n, int[][] indices) { int[] r = new int[m], c = new int[n];
        for (int[] idx : indices) { r[idx[0]]++;
            c[idx[1]]++;
        } int cnt = 0;
        for (int i = 0;
        i < m;
        i++) for (int j = 0;
        j < n;
        j++) if ((r[i] + c[j]) % 2 == 1) cnt++;
        return cnt;
    };
}
