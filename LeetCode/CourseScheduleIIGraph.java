
import java.util.*;
public class CourseScheduleIIGraph {

    public int[] findOrder(int numCourses, int[][] prerequisites) { int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;
        i < numCourses;
        i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) { adj.get(p[1]).add(p[0]);
            in[p[0]]++;
        } Queue<Integer> q = new LinkedList<>();
        for (int i = 0;
        i < numCourses;
        i++) if (in[i] == 0) q.add(i);
        int[] res = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) { int cur = q.poll();
            res[idx++] = cur;
            for (int nxt : adj.get(cur)) if (--in[nxt] == 0) q.add(nxt);
        } return idx == numCourses ? res : new int[0];
    };
}
