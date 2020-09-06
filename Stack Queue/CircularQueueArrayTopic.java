public class CircularQueueArrayTopic {

    private int[] a;
    private int head = 0, tail = 0, cnt = 0, cap;

    public CircularQueueArrayTopic(int k) { cap = k;
        a = new int[k];
    } public boolean enQueue(int val) { if (isFull()) return false;
        a[tail] = val;
        tail = (tail + 1) % cap;
        cnt++;
        return true;
    } public boolean deQueue() { if (isEmpty()) return false;
        head = (head + 1) % cap;
        cnt--;
        return true;
    } public int Front() { return isEmpty() ? -1 : a[head];
    } public int Rear() { return isEmpty() ? -1 : a[(tail - 1 + cap) % cap];
    } public boolean isEmpty() { return cnt == 0;
    } public boolean isFull() { return cnt == cap;
    };
}
