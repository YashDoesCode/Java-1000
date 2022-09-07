public class StackArray {

    private int[] a;
    private int top = -1;

    public StackArray(int size) { a = new int[size];
    } public void push(int val) { a[++top] = val;
    } public int pop() { return a[top--];
    } public int peek() { return a[top];
    } public boolean isEmpty() { return top == -1;
    };
}
