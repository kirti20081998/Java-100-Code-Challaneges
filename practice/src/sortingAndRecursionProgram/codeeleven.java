package sortingAndRecursionProgram;

import java.util.ArrayList;
import java.util.List;

public class codeeleven {

	public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> result = new ArrayList<>();

		// Traverse the string to find operators
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (c == '+' || c == '-' || c == '*') {
				// Split into left and right parts
				String left = expression.substring(0, i);
				String right = expression.substring(i + 1);

				// Recursively calculate results from both sides
				List<Integer> leftResults = diffWaysToCompute(left);
				List<Integer> rightResults = diffWaysToCompute(right);

				// Combine results
				for (int l : leftResults) {
					for (int r : rightResults) {
						if (c == '+') {
							result.add(l + r);
						} else if (c == '-') {
							result.add(l - r);
						} else if (c == '*') {
							result.add(l * r);
						}
					}
				}
			}
		}

		// If result is empty, it means it's a number with no operator
		if (result.isEmpty()) {
			result.add(Integer.parseInt(expression));
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		codeeleven ec = new codeeleven();
		String expression = "2*3-4*5";
		List<Integer> results = ec.diffWaysToCompute(expression);

		System.out.println("All possible results:");
		for (int res : results) {
			System.out.println(res);
		}
	}

}
