import java.util.*;
public class FrontMiddleBackQueueTopic {

    private LinkedList<Integer> list = new LinkedList<>();

    public void pushFront(int val) { list.addFirst(val);
    } public void pushMiddle(int val) { list.add(list.size() / 2, val);
    } public void pushBack(int val) { list.addLast(val);
    } public int popFront() { return list.isEmpty() ? -1 : list.removeFirst();
    } public int popMiddle() { return list.isEmpty() ? -1 : list.remove((list.size() - 1) / 2);
    } public int popBack() { return list.isEmpty() ? -1 : list.removeLast();
    };
}
