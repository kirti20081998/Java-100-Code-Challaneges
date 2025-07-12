/*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t(including duplicates) is included in the window. if there is no 
  such substring, return the empty string "".*/
package stringprogram;

import java.util.HashMap;
import java.util.Map;

public class codethird {
	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";

		Map<Character, Integer> tMap = new HashMap<>();

		for (char c : t.toCharArray()) {
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> window = new HashMap<>();
		int left = 0, right = 0;
		int minLen = Integer.MAX_VALUE;
		int start = 0;
		int required = tMap.size();
		int formed = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			window.put(c, window.getOrDefault(c, 0) + 1);
			if (tMap.containsKey(c) && window.get(c).intValue() == tMap.get(c).intValue()) {
				formed++;
			}

			// Try to shrink the window
			while (left <= right && formed == required) {
				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					start = left;
				}

				char leftChar = s.charAt(left);
				window.put(leftChar, window.get(leftChar) - 1);
				if (tMap.containsKey(leftChar) && window.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
					formed--;
				}
				left++;
			}
			right++;
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
	}

	public static void main(String[] args) {
		codethird mws = new codethird();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String result = mws.minWindow(s, t);
		System.out.println("Minimum Window Substring: " + result);
	}
}
