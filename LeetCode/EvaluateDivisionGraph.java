
import java.util.*;
public class EvaluateDivisionGraph {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) { Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0;
        i < equations.size();
        i++) { String u = equations.get(i).get(0), v = equations.get(i).get(1);
            double val = values[i];
            g.putIfAbsent(u, new HashMap<>());
            g.putIfAbsent(v, new HashMap<>());
            g.get(u).put(v, val);
            g.get(v).put(u, 1.0 / val);
        } double[] res = new double[queries.size()];
        for (int i = 0;
        i < queries.size();
        i++) { String src = queries.get(i).get(0), dst = queries.get(i).get(1);
            if (!g.containsKey(src) || !g.containsKey(dst)) res[i] = -1.0;
            else res[i] = dfs(g, src, dst, new HashSet<>(), 1.0);
        } return res;
    } private double dfs(Map<String, Map<String, Double>> g, String src, String dst, Set<String> vis, double acc) { vis.add(src);
        if (src.equals(dst)) return acc;
        Map<String, Double> nbrs = g.get(src);
        for (String nxt : nbrs.keySet()) { if (!vis.contains(nxt)) { double res = dfs(g, nxt, dst, vis, acc * nbrs.get(nxt));
                if (res != -1.0) return res;
            } } return -1.0;
    };
}
