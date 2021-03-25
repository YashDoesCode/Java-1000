
public class XORQueriesOfSubarrayBit {

    public int[] xorQueries(int[] arr, int[][] queries) { int n = arr.length;
        int[] p = new int[n + 1];
        for (int i = 0;
        i < n;
        i++) p[i + 1] = p[i] ^ arr[i];
        int[] res = new int[queries.length];
        for (int i = 0;
        i < queries.length;
        i++) res[i] = p[queries[i][1] + 1] ^ p[queries[i][0]];
        return res;
    };
}
