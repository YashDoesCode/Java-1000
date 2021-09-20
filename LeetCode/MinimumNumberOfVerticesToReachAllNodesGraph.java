
import java.util.*;
public class MinimumNumberOfVerticesToReachAllNodesGraph {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) { boolean[] hasIn = new boolean[n];
        for (List<Integer> e : edges) hasIn[e.get(1)] = true;
        List<Integer> res = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) if (!hasIn[i]) res.add(i);
        return res;
    };
}
