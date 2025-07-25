//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

package sortingAndRecursionProgram;

import java.util.ArrayList;
import java.util.List;

public class codefive {

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backtrack(result, "", 0, 0, n);
		return result;
	}

	private static void backtrack(List<String> result, String current, int open, int close, int max) {
		// Base case: if the current string is complete
		if (current.length() == max * 2) {
			result.add(current);
			return;
		}

		// Add an opening bracket if available
		if (open < max) {
			backtrack(result, current + "(", open + 1, close, max);
		}

		// Add a closing bracket if it won't exceed the number of open brackets
		if (close < open) {
			backtrack(result, current + ")", open, close + 1, max);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		List<String> combinations = generateParenthesis(n);
		System.out.println("All well-formed parentheses combinations for n = " + n + ":");
		for (String s : combinations) {
			System.out.println(s);
		}
	}

}
