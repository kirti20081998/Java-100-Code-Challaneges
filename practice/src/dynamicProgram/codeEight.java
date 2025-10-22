package dynamicProgram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class codeEight {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // base case

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further
                }
            }
        }

        return dp[s.length()];
    }

    // Example usage
    public static void main(String[] args) {
    	codeEight solver = new codeEight();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(solver.wordBreak(s, wordDict)); // Output: true
    }

}
