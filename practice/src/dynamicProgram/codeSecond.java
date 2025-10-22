/*
 Given an integer array nums, return the length of the longest strictly increasing subsequence
 */

package dynamicProgram;

public class codeSecond {
	
	 public int lengthOfLIS(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;

	        int n = nums.length;
	        int[] dp = new int[n];
	        int maxLen = 1;

	        // Every element is an LIS of length 1 by itself
	        for (int i = 0; i < n; i++) {
	            dp[i] = 1;
	        }

	        // Build dp table
	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                }
	            }
	            maxLen = Math.max(maxLen, dp[i]);
	        }

	        return maxLen;
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	codeSecond solver = new codeSecond();
	        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
	        System.out.println(solver.lengthOfLIS(nums)); // Output: 4  (2,3,7,101)
	    }

}
