/*Given an integer array nums of unique elements, return al possible Subsets(the power set). The solution set must not  contain duplicate subsets.
 * Return the solution in any order.*/

package sortingAndRecursionProgram;

import java.util.ArrayList;
import java.util.List;

public class codesix {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Try adding each element one by one
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]); // choose
            backtrack(result, current, nums, i + 1); // explore
            current.remove(current.size() - 1); // un-choose (backtrack)
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> powerSet = subsets(nums);

        System.out.println("All subsets (power set):");
        for (List<Integer> subset : powerSet) {
            System.out.println(subset);
        }
    }
}
