/*
 * You are given an array of integers nums, there are sliding window of size k which is moving from the very 
 * left of the array to the very right.You can only see the k numbers in the window.Each times the sliding 
 * window moves right by one position. Return the max sliding window.
 */

package stackQueueProgram;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class codeEight {

	 public int[] maxSlidingWindow(int[] nums, int k) {
	        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

	        int n = nums.length;
	        int[] result = new int[n - k + 1];
	        Deque<Integer> deque = new LinkedList<>();

	        for (int i = 0; i < n; i++) {
	            // Remove indices that are out of this window
	            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
	                deque.pollFirst();
	            }

	            // Maintain decreasing order in deque
	            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
	                deque.pollLast();
	            }

	            // Add current index
	            deque.offerLast(i);

	            // Start recording results when the first window is ready
	            if (i >= k - 1) {
	                result[i - k + 1] = nums[deque.peekFirst()];
	            }
	        }

	        return result;
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	codeEight solver = new codeEight();
	        int[] nums = {1,3,-1,-3,5,3,6,7};
	        int k = 3;
	        int[] res = solver.maxSlidingWindow(nums, k);
	        System.out.println(Arrays.toString(res)); // [3,3,5,5,6,7]
	    }

}
