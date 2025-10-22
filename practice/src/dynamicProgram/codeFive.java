/*
 Given a non-empty array nums containing only positive integers, find if the array can be partitioned into 
 two subsets such that the sum of elements in both subsets is equal.
 */

package dynamicProgram;

public class codeFive {
	
	public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If total sum is odd → cannot partition equally
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // base case

        // Process each number
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }

    // Example usage
    public static void main(String[] args) {
    	codeFive solver = new codeFive();
        int[] nums = {1, 5, 11, 5};
        System.out.println(solver.canPartition(nums)); // Output: true
    }

}
