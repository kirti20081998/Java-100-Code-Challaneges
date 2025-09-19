/*Given an array nums containing n distinct numbers in the range[0,n], return the only number in the 
 * range that is missing from the array.*/

package mathProgram;

public class codeFirst {
	
	public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    // Example usage
    public static void main(String[] args) {
    	codeFirst solution = new codeFirst();

        int[] nums1 = {3, 0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums1)); // 2

        int[] nums2 = {0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums2)); // 2

        int[] nums3 = {9,6,4,2,3,5,7,0,1};
        System.out.println("Missing number: " + solution.missingNumber(nums3)); // 8
    }

}
