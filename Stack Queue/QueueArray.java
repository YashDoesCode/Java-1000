/*
 * Popular Question: Design Circular Queue
 * Source: LeetCode #622 (Medium)
 *
 * Problem Statement:
 * Design your implementation of the circular queue. The circular queue is a linear data structure
 * in which the operations are performed based on FIFO (First In First Out) principle and the last position
 * is connected back to the first position to make a circle. It is also called "Ring Buffer".
 *
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space
 * in front of the queue. But using the circular queue, we can use the space to store new values.
 *
 * Implementation details:
 * - QueueArray(k): Initializes the object with the size of the queue to be k.
 * - int Front(): Gets the front item from the queue. If the queue is empty, return -1.
 * - int Rear(): Gets the last item from the queue. If the queue is empty, return -1.
 * - boolean enQueue(int value): Inserts an element into the circular queue. Return true if operation is successful.
 * - boolean deQueue(): Deletes an element from the circular queue. Return true if operation is successful.
 * - boolean isEmpty(): Checks whether the circular queue is empty or not.
 * - boolean isFull(): Checks whether the circular queue is full or not.
 *
 * Example 1:
 * Input:
 * ["QueueArray", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * Output:
 * [null, true, true, true, false, 3, true, true, true, 4]
 *
 * Constraints:
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.
 */

public class QueueArray {

    private final int[] data;
    private int head;
    private int tail;
    private int size;
    private final int capacity;

    public QueueArray(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        QueueArray circularQueue = new QueueArray(3);

        System.out.println("enQueue(1): " + circularQueue.enQueue(1));
        System.out.println("enQueue(2): " + circularQueue.enQueue(2));
        System.out.println("enQueue(3): " + circularQueue.enQueue(3));
        System.out.println("enQueue(4): " + circularQueue.enQueue(4));

        System.out.println("Rear: " + circularQueue.Rear());
        System.out.println("isFull: " + circularQueue.isFull());

        System.out.println("deQueue: " + circularQueue.deQueue());
        System.out.println("enQueue(4): " + circularQueue.enQueue(4));

        System.out.println("Rear: " + circularQueue.Rear());
        System.out.println("Front: " + circularQueue.Front());
    }
}
