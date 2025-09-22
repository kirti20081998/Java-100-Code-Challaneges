/*
 * Design your implemetation of the circular queue.The circular queue is a linear data structure in 
 * which the operations are performed based on FIFO principle, and the last operation is connected back 
 * to the first postion to make a circle. It is also called "Ring Buffer"
 */

package stackQueueProgram;

public class codeSeventh {
	
	private int[] queue;
    private int front, rear, count, size;

    public codeSeventh(int k) {
        queue = new int[k];
        size = k;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Insert element into circular queue. Return true if successful.
    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % size;
        queue[rear] = value;
        count++;
        return true;
    }

    // Delete element from circular queue. Return true if successful.
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % size;
        count--;
        return true;
    }

    // Get the front item from the queue.
    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    // Get the last item from the queue.
    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    // Check whether the circular queue is empty.
    public boolean isEmpty() {
        return count == 0;
    }

    // Check whether the circular queue is full.
    public boolean isFull() {
        return count == size;
    }

    // Example usage
    public static void main(String[] args) {
    	codeSeventh cq = new codeSeventh(3);

        System.out.println(cq.enQueue(1)); // true
        System.out.println(cq.enQueue(2)); // true
        System.out.println(cq.enQueue(3)); // true
        System.out.println(cq.enQueue(4)); // false (queue full)

        System.out.println(cq.Rear());  // 3
        System.out.println(cq.isFull()); // true

        System.out.println(cq.deQueue()); // true
        System.out.println(cq.enQueue(4)); // true
        System.out.println(cq.Rear()); // 4
    }

}
