/*
 Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space 
 seperated sequence of one or more dictionary words.Note that the same word in the dictionary may be reused
 multiple times in the segmentation.
 */

package triesProgram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class codeFour {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further j
                }
            }
        }

        return dp[n];
    }

    // Example usage
    public static void main(String[] args) {
    	codeFour solver = new codeFour();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(solver.wordBreak(s, wordDict)); // true

        s = "applepenapple";
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(solver.wordBreak(s, wordDict)); // true

        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(solver.wordBreak(s, wordDict)); // false
    }

}
