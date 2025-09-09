/* You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff.A triplet (i, j, k) is an 
arithmatic triplet(i,j,k) is an arithmatic triplet if the following conditions are met: 
i < j < k,
nums[i] - nums[j] == diff,and
nums[k] - nums[j] == diff.
Return the number of unique arithmatic triplets.*/

package hashingProgram;

import java.util.HashSet;
import java.util.Set;

public class codefourth {
	
	public int countArithmeticTriplets(int[] nums, int diff) {
        Set<Integer> seen = new HashSet<>();
        int count = 0;

        for (int num : nums) {
            // Check if num - diff and num - 2*diff exist
            if (seen.contains(num - diff) && seen.contains(num - 2 * diff)) {
                count++;
            }
            seen.add(num); // Add current number to the set
        }

        return count;
    }

    public static void main(String[] args) {
    	codefourth solution = new codefourth();
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int result = solution.countArithmeticTriplets(nums, diff);
        System.out.println("Number of arithmetic triplets: " + result);
    }

}
