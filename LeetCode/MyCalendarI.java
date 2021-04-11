
import java.util.*;
public class MyCalendarI {

    private TreeMap<Integer, Integer> cal = new TreeMap<>();

    public boolean book(int start, int end) { Integer prev = cal.floorKey(start), next = cal.ceilingKey(start);
        if ((prev == null || cal.get(prev) <= start) && (next == null || end <= next)) { cal.put(start, end);
            return true;
        } return false;
    };
}
