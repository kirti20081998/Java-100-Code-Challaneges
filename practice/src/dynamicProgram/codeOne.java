/*
 Given a integer array nums, find a subarray that has the largest product, and return the product.
 */

package dynamicProgram;

public class codeOne {
	
	 public int maxProduct(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;

	        int maxSoFar = nums[0];
	        int minSoFar = nums[0];
	        int result = nums[0];

	        for (int i = 1; i < nums.length; i++) {
	            int curr = nums[i];

	            // If current number is negative, swap max and min
	            if (curr < 0) {
	                int temp = maxSoFar;
	                maxSoFar = minSoFar;
	                minSoFar = temp;
	            }

	            // Compute new max and min
	            maxSoFar = Math.max(curr, maxSoFar * curr);
	            minSoFar = Math.min(curr, minSoFar * curr);

	            // Update result
	            result = Math.max(result, maxSoFar);
	        }

	        return result;
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	codeOne solver = new codeOne();
	        int[] nums1 = {2, 3, -2, 4};
	        int[] nums2 = {-2, 0, -1};
	        System.out.println(solver.maxProduct(nums1)); // Output: 6  (2*3)
	        System.out.println(solver.maxProduct(nums2)); // Output: 0
	    }

}
