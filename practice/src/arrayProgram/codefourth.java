/* The next  permutation of an array of integers is the next lexicographically greater permutation of its integer. Given an array of integers nums, 
   find the next permutation of nums.
   The replacement must be in place and use only constant extra memory.
*/
package arrayProgram;

import java.util.Arrays;

public class codefourth {
	
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n-2;
		
		 // Step 1: Find first decreasing element from the end
		while(i>=0 && nums[i]>=nums[i+1]) {
			i--;
		}
		
		// Step 2: If found, swap with the next larger element on the right
		if(i >= 0) {
			int j = n - 1;
			while(nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		
		reverse(nums, i+1, n-1);
	}
	
	// Swap helper method
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	// Reverse helper method
	private void reverse(int[] nums, int start, int end) {
		while(start < end) {
			swap(nums, start++, end--);
		}
	}
	
	// Main method for testing
	public static void main(String[] args) {
		codefourth np = new codefourth();
		int[] nums = {1, 4, 6};
		np.nextPermutation(nums);
		System.out.println("Next permutation: " + Arrays.toString(nums));
	}
	
	

}
