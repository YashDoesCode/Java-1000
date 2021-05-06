import java.util.*;

public class PriorityQueueHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueueHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void push(int val) {
        if (size == capacity) return;
        heap[size] = val;
        int i = size;
        size++;
        while (i != 0 && heap[(i - 1) / 2] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    public int pop() {
        if (size <= 0) return Integer.MAX_VALUE;
        if (size == 1) { size--; return heap[0]; }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);
        return root;
    }

    private void minHeapify(int i) {
        int left = 2 * i + 1, right = 2 * i + 2, smallest = i;
        if (left < size && heap[left] < heap[smallest]) smallest = left;
        if (right < size && heap[right] < heap[smallest]) smallest = right;
        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }
}
