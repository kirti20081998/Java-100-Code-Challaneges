/*Given a non-empty array of integers nums, every element appears twice except for one. 
 * Find that single one. You must implement a solution with linear runtime complexity and 
 * use only constant extra space.*/

package mathProgram;

public class javaThird {
	
	public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR accumulates
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
    	javaThird solution = new javaThird();

        int[] nums1 = {2, 2, 1};
        System.out.println("Single number: " + solution.singleNumber(nums1)); // 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single number: " + solution.singleNumber(nums2)); // 4

        int[] nums3 = {1};
        System.out.println("Single number: " + solution.singleNumber(nums3)); // 1
    }

}
