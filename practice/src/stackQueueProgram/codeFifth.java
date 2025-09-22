/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 */

package stackQueueProgram;

public class codeFifth {
	
	public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    // Example usage
    public static void main(String[] args) {
    	codeFifth solver = new codeFifth();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solver.trap(heights)); // Output: 6
    }

}
