/* Give an array of strings strs, group the anagrams together. You can return the answer in any order. An Anagram is a word or phase formed 
   by rearranging the letters of a different word or phase, typically using all the original letters exactly once.
 */
package stringProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class codefifth {
	public List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> map = new HashMap<>();
		for(String word : strs) {
			
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
		}
		
		return new ArrayList<>(map.values());
	}
	
	public static void main(String[] args) {
		codefifth obj = new codefifth();
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = obj.groupAnagrams(input);
		
		System.out.println("Grouped Anagrams: ");
		for(List<String> group : result) {
			System.out.println(group);
		}
	}
}
