
import java.util.*;
public class FlattenNestedListIterator {

    private List<Integer> list = new ArrayList<>();
    private Iterator<Integer> it;

    public FlattenNestedListIterator(List<Object> nestedList) { flatten(nestedList);
        it = list.iterator();
    } private void flatten(List<Object> nList) { for (Object obj : nList) { if (obj instanceof Integer) list.add((Integer) obj);
            else flatten((List<Object>) obj);
        } } public Integer next() { return it.next();
    } public boolean hasNext() { return it.hasNext();
    };
}
