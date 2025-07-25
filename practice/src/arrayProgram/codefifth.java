// Given an array of integers and an integer target, return indices of the two numbers such that they add up to target.

package arrayProgram;

import java.util.HashMap;
import java.util.Map;

public class codefifth {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}

			map.put(nums[i], i);
		}

		return new int[] {};

	}

	public static void main(String[] args) {
		codefifth ts = new codefifth();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = ts.twoSum(nums, target);

		System.out.println("Indices: " + result[0] + "," + result[1]);
	}
}
