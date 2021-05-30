import java.util.*;
public class CustomGenericStack<T> {

    private List<T> list = new ArrayList<>();

    public void push(T val) {
        list.add(val);
    }

    public T pop() {
        return list.isEmpty() ? null : list.remove(list.size() - 1);
    }

    public T peek() {
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
