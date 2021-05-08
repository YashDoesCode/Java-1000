import java.util.Stack;

public class MinStackEngine {

    private final Stack<Integer> s = new Stack<>();
    private final Stack<Integer> minS = new Stack<>();

    public void push(int val) {
        s.push(val);
        if (minS.isEmpty() || val <= minS.peek()) {
            minS.push(val);
        }
    }

    public void pop() {
        if (s.isEmpty()) return;
        int val = s.pop();
        if (val == minS.peek()) {
            minS.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
