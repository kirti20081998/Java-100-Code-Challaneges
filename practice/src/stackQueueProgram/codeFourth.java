/*
 Given an array of integers heights representing the histogram's bar height where the width of 
 the each bar is 1, return the area of the largest rectangle in the histogram.
 */

package stackQueueProgram;

import java.util.Stack;

public class codeFourth {
	
	 public int largestRectangleArea(int[] heights) {
	        int n = heights.length;
	        Stack<Integer> stack = new Stack<>();
	        int maxArea = 0;

	        for (int i = 0; i <= n; i++) {
	            // For convenience, use 0 as sentinel at the end
	            int h = (i == n) ? 0 : heights[i];
	            while (!stack.isEmpty() && h < heights[stack.peek()]) {
	                int height = heights[stack.pop()];
	                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
	                maxArea = Math.max(maxArea, height * width);
	            }
	            stack.push(i);
	        }

	        return maxArea;
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	codeFourth solver = new codeFourth();
	        int[] heights = {2, 1, 5, 6, 2, 3};
	        System.out.println(solver.largestRectangleArea(heights)); // Output: 10
	    }

}
