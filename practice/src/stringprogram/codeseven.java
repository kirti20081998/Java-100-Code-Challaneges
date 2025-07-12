/* Given a string s, sort it in decreasing order based on the frequency of the characters.The frequency of a character is the number of times
   it appear in the string.Return the sorted string. If there are multiple answers, return any of them.
 */
package stringprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class codeseven {
	public String frequencySort(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
		
		maxHeap.addAll(freqMap.keySet());
		
		StringBuilder result = new StringBuilder();
		while(!maxHeap.isEmpty()) {
			char c = maxHeap.poll();
			int freq = freqMap.get(c);
			result.append(String.valueOf(c).repeat(freq));
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		codeseven sorter = new codeseven();
		String s = "tree";
		String sorted = sorter.frequencySort(s);
		System.out.println("Sorted by frequency: " + sorted);
	}

}
