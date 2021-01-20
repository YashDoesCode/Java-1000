
public class MinimumOperationsToMakeArrayEqualMatrix {

    public int minOperations(int[][] grid, int x) { int m = grid.length, n = grid[0].length, idx = 0;
        int[] a = new int[m * n];
        for (int i = 0;
        i < m;
        i++) for (int j = 0;
        j < n;
        j++) a[idx++] = grid[i][j];
        java.util.Arrays.sort(a);
        int med = a[a.length / 2], ans = 0;
        for (int v : a) { if (Math.abs(v - med) % x != 0) return -1;
            ans += Math.abs(v - med) / x;
        } return ans;
    };
}
