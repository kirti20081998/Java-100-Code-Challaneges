/*Given a string s,partition s susch that every substring of the partition is palindrome return all possible palindrome partitioning of s.*/

package sortingAndRecursionProgram;

import java.util.ArrayList;
import java.util.List;

public class codeeight {

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		backtrack(s, 0, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<>(currentList));
			return;
		}

		for (int end = start + 1; end <= s.length(); end++) {
			String substring = s.substring(start, end);
			if (isPalindrome(substring)) {
				currentList.add(substring);
				backtrack(s, end, currentList, result);
				currentList.remove(currentList.size() - 1); // backtrack
			}
		}
	}

	private static boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaba";
		List<List<String>> partitions = partition(s);

		System.out.println("Palindrome partitions:");
		for (List<String> list : partitions) {
			System.out.println(list);
		}
	}

}
