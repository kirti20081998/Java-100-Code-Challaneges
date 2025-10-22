/*
 Given two strings text1 and text2, return the length of their longest common subsequence.
 If there is no common subsequence , return 0.
 */

package dynamicProgram;

public class codeSix {
	
	public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Example usage
    public static void main(String[] args) {
    	codeSix solver = new codeSix();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(solver.longestCommonSubsequence(text1, text2)); // Output: 3
    }

}
