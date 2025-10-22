/*
 Given two strings word1 and word2 , return the minimum number of operations required to convert word1 and word2. 
 You have the following three operations permitted on a word: 
 Insert a character 
 Delete a character 
 Replace a character
 */

package dynamicProgram;

public class codeThird {
	
	 public int minDistance(String word1, String word2) {
	        int m = word1.length();
	        int n = word2.length();

	        int[][] dp = new int[m + 1][n + 1];

	        // Base cases
	        for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all chars
	        for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all chars

	        // Build DP table
	        for (int i = 1; i <= m; i++) {
	            for (int j = 1; j <= n; j++) {
	                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
	                    dp[i][j] = dp[i - 1][j - 1]; // no operation needed
	                } else {
	                    dp[i][j] = 1 + Math.min(
	                        dp[i - 1][j],          // delete
	                        Math.min(dp[i][j - 1], // insert
	                                 dp[i - 1][j - 1]) // replace
	                    );
	                }
	            }
	        }

	        return dp[m][n];
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	codeThird solver = new codeThird();
	        String word1 = "horse";
	        String word2 = "ros";
	        System.out.println(solver.minDistance(word1, word2)); // Output: 3
	    }

}
