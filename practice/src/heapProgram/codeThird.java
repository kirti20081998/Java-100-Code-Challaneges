/*
 Given a string s, rearrange the characters of s so that any two adjacent characters are not the same. 
 Return any possible rearrangement of s or return "" if not possible.
 */
package heapProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class codeThird {
	
	public String reorganizeString(String s) {
        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max-heap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();

        // Step 3: Build result
        while (maxHeap.size() >= 2) {
            Map.Entry<Character, Integer> first = maxHeap.poll();
            Map.Entry<Character, Integer> second = maxHeap.poll();

            // append the two most frequent different characters
            result.append(first.getKey());
            result.append(second.getKey());

            first.setValue(first.getValue() - 1);
            second.setValue(second.getValue() - 1);

            if (first.getValue() > 0) maxHeap.offer(first);
            if (second.getValue() > 0) maxHeap.offer(second);
        }

        // Step 4: Handle last leftover character
        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> last = maxHeap.poll();
            if (last.getValue() > 1) return ""; // not possible
            result.append(last.getKey());
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
    	codeThird solver = new codeThird();
        System.out.println(solver.reorganizeString("aab"));   // "aba"
        System.out.println(solver.reorganizeString("aaab"));  // ""
    }

}
