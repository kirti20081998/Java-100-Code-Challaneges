package heapProgram;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
	private PriorityQueue<Integer> left;  // max-heap
    private PriorityQueue<Integer> right; // min-heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        right = new PriorityQueue<>(); // min-heap
    }

    // Add number into data structure
    public void addNum(int num) {
        // Step 1: Add to max-heap first
        left.offer(num);

        // Step 2: Balance heaps (ensure left.max <= right.min)
        right.offer(left.poll());

        // Step 3: Rebalance sizes (left can have one extra element)
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    // Find median
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek(); // left will have the extra element
        }
    }

    // Example usage
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2
    }

}
