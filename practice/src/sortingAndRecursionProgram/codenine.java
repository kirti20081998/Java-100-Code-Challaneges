/*Given a collection of candidate numbers(candidates) and a target number(target), find all unique combinations in candidates where the 
 * candidate numbers sum to traget.Each number in candidates may only be used once in the combination.
 * Note : the solution set must not contain duplicate combinations.
*/

package sortingAndRecursionProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class codenine {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to help with skipping duplicates
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > remaining) break; // No point in continuing

            tempList.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i + 1, tempList, result); // i+1 because each number used only once
            tempList.remove(tempList.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		codenine solver = new codenine();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> combinations = solver.combinationSum2(candidates, target);
        System.out.println("Unique combinations that sum to " + target + ":");
        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }

	}

}
