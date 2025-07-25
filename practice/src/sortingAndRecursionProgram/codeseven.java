//Given an array nums of distinct integers, return all the possible permutations.You can return the answer in any order.

package sortingAndRecursionProgram;

import java.util.ArrayList;
import java.util.List;

public class codeseven {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<>(tempList)); // Found a full permutation
			return;
		}

		for (int num : nums) {
			if (tempList.contains(num))
				continue; // Skip used numbers
			tempList.add(num);
			backtrack(nums, tempList, result);
			tempList.remove(tempList.size() - 1); // Backtrack
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		List<List<Integer>> permutations = permute(nums);

		System.out.println("All permutations:");
		for (List<Integer> p : permutations) {
			System.out.println(p);
		}
	}

}
