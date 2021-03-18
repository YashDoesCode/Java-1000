public class CircularQueueBuffer {

    private final int[] data;
    private int head = 0, tail = 0, size = 0;

    public CircularQueueBuffer(int capacity) {
        data = new int[capacity];
    }

    public boolean enqueue(int val) {
        if (size == data.length) return false;
        data[tail] = val;
        tail = (tail + 1) % data.length;
        size++;
        return true;
    }

    public int dequeue() {
        if (size == 0) return -1;
        int val = data[head];
        head = (head + 1) % data.length;
        size--;
        return val;
    }
}
