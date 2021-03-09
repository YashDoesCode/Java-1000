
import java.util.*;
public class MinimumFuelCostToReportToTheCapitalGraph {

    private long fuel = 0;

    public long minimumFuelCost(int[][] roads, int seats) { List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;
        i <= roads.length;
        i++) adj.add(new ArrayList<>());
        for (int[] r : roads) { adj.get(r[0]).add(r[1]);
            adj.get(r[1]).add(r[0]);
        } dfs(adj, 0, -1, seats);
        return fuel;
    } private long dfs(List<List<Integer>> adj, int u, int p, int seats) { long people = 1;
        for (int v : adj.get(u)) if (v != p) people += dfs(adj, v, u, seats);
        if (u != 0) fuel += (people + seats - 1) / seats;
        return people;
    };
}
