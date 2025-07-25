package hashingProgram;

import java.util.HashMap;

public class codeone {

	public static int[] twoSum(int[] nums, int target) {
		// HashMap to store number and its index
		HashMap<Integer, Integer> map = new HashMap<>();

		// Iterate through the array
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i]; // what we need to reach target

			// If the complement is already in the map, we found the answer
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}

			// Store current number with its index
			map.put(nums[i], i);
		}

		// If no pair found
		throw new IllegalArgumentException("No two sum solution found.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 11, 15, 7 };
		int target = 9;

		int[] result = twoSum(nums, target);
		System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");

	}

}
