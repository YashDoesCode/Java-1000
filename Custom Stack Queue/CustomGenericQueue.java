import java.util.*;
public class CustomGenericQueue<T> {

    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T val) {
        list.addLast(val);
    }

    public T dequeue() {
        return list.isEmpty() ? null : list.removeFirst();
    }

    public T peek() {
        return list.peekFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
