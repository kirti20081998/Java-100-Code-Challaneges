/*You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
  You can perform this operation at most k times.*/
package stringprogram;

public class codefourth {
	public int characterReplacement(String s, int k) {
		int [] count = new int[26];  // Count of each letter
		int maxCount = 0; // Count of most frequent letter in current window
		int maxLength = 0;
		
		int left = 0;
		
		for(int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			count[c - 'A']++;
			maxCount = Math.max(maxCount, count[c - 'A']);
			
			// If we need to replace more than k characters, shrink the window
			while((right - left + 1) - maxCount > k) {
				count[s.charAt(left) - 'A']--;
				left++;
			}
			
			maxLength = Math.max(maxLength, right - left + 1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		codefourth cr = new codefourth();
		String s = "AABABBA";
		int k = 1;
		int  result = cr.characterReplacement(s, k);
		System.out.println("Longest Substring Length : " + result);
	}
}
