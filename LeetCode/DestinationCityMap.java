
import java.util.*;
public class DestinationCityMap {

    public String destCity(List<List<String>> paths) { Set<String> src = new HashSet<>();
        for (List<String> p : paths) src.add(p.get(0));
        for (List<String> p : paths) if (!src.contains(p.get(1))) return p.get(1);
        return "";
    };
}
