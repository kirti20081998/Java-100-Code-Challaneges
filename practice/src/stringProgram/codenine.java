/*Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise. In other words, return true if one of s1's permutations is the substring of s2 */
package stringProgram;

public class codenine {
	public static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;

		int[] s1Count = new int[26];
		int[] windowCount = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			s1Count[s1.charAt(i) - 'a']++;
			windowCount[s2.charAt(i) - 'a']++;
		}

		if (matches(s1Count, windowCount))
			return true;

		for (int i = s1.length(); i < s2.length(); i++) {
			windowCount[s2.charAt(i) - 'a']++;
			windowCount[s2.charAt(i - s1.length()) - 'a']--;

			if (matches(s1Count, windowCount))
				return true;
		}

		return false;
	}

	private static boolean matches(int[] a, int[] b) {
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";

		System.out.println(checkInclusion(s1, s2));
	}
}
