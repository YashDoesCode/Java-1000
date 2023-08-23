import java.util.*;
public class KnightMoves3DBFS {

    public int minKnightMoves(int x, int y, int z) { Queue<int[]> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(new int[]{0, 0, 0, 0});
        vis.add("0,0,0");
        int[][] moves = {{1,2,0},{-1,2,0},{2,1,0},{-2,1,0},{0,1,2},{0,-1,2}};
        while (!q.isEmpty()) { int[] cur = q.poll();
            if (cur[0] == x && cur[1] == y && cur[2] == z) return cur[3];
            for (int[] m : moves) { int nx = cur[0] + m[0], ny = cur[1] + m[1], nz = cur[2] + m[2];
                String key = nx + "," + ny + "," + nz;
                if (!vis.contains(key)) { vis.add(key);
                    q.add(new int[]{nx, ny, nz, cur[3] + 1});
                } } } return -1;
    };
}
