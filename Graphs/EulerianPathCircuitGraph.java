import java.util.*;
public class EulerianPathCircuitGraph {

    public List<Integer> findEulerianPath(int n, List<List<Integer>> adj) { List<Integer> path = new ArrayList<>();
        int[] deg = new int[n];
        for (int u = 0;
        u < n;
        u++) deg[u] = adj.get(u).size();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        while (!st.isEmpty()) { int u = st.peek();
            if (!adj.get(u).isEmpty()) { int v = adj.get(u).remove(adj.get(u).size() - 1);
                st.push(v);
            } else path.add(st.pop());
        } Collections.reverse(path);
        return path;
    };
}
