/* Given an array of positive integers nums  and a positive integer target, return the minimal length of a subarray whose sum is greater than or 
 equal to target.if there is no such subarray, return O instead. */
package arrayProgram;

public class codeeight {
	public int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;
		int minLen = Integer.MAX_VALUE;
		int left = 0, sum = 0;
		for(int right = 0; right < n; right++) {
			sum += nums[right];
			
			// Try to shrink the window from the left
			while(sum >= target) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left++];
			}
		}
		
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	
	public static void main(String[] args) {
		codeeight obj = new codeeight();
		int[] nums = {2, 3, 1, 2, 4, 3};
		int target = 7;
		int result = obj.minSubArrayLen(target, nums);
		System.out.println("Minimum Subarray Length: " + result);
	}
}
