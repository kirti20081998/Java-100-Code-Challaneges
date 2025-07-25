/*Given two strings s and p, return an array of all the start indices of p's anagrams in s.*/
package stringProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class codesecond {
	public List<Integer> findAnagrams(String s , String p){
		List<Integer> result = new ArrayList<>();
		
		if(s.length() < p.length()) return result;
		
		int[] pCount = new int[26];
		int[] sCount = new int[26];
		
		// Build frequency map for string p
		for(char c: p.toCharArray()) {
			pCount[c - 'a']++;
		}
		
		// Sliding window over s
		for(int i = 0;i < s.length(); i++) {
			sCount[s.charAt(i) - 'a']++; // include current char
			
			 // Remove character left out of window
			if(i >= p.length()) {
				sCount[s.charAt(i - p.length()) - 'a']--;
			}
			
			// Compare frequency maps
			if(Arrays.equals(pCount, sCount)) {
				result.add(i - p.length() + 1);  // valid anagram start index
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		codesecond fa = new codesecond();
		String s = "cbaebabacd";
		String p = "abc";
		
		List<Integer> indices = fa.findAnagrams(s, p);
		System.out.println("Anagram Start Indices: " + indices);
	}
}
