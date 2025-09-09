/* Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time uses constant extra space. */

package hashingProgram;

public class codesecond {
	
	public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        
        for (int i = 0; i < n; i++) {
            while (
                nums[i] > 0 && nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: Find the first index where the value is not i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all values are placed correctly, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
    	codesecond obj = new codesecond();
        int[] nums = {3, 4, -1, 1};
        System.out.println("Smallest missing positive: " + obj.firstMissingPositive(nums)); // Output: 2
    }

}
