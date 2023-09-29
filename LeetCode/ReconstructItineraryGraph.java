
import java.util.*;
public class ReconstructItineraryGraph {

    private Map<String, PriorityQueue<String>> targets = new HashMap<>();

    private List<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) { for (List<String> t : tickets) { targets.putIfAbsent(t.get(0), new PriorityQueue<>());
            targets.get(t.get(0)).add(t.get(1));
        } visit("JFK");
        return route;
    } private void visit(String airport) { while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) visit(targets.get(airport).poll());
        route.add(0, airport);
    };
}
