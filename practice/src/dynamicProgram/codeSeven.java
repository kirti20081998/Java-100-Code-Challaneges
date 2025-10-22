/*
 There is a robot on an m X n grid. The robot is initially located at 
 the top-left corner(i.e , grif[0][0]).The robot tries to move to the bottom-right corner(i.e , 
 grif[m-1][n-1]).The robot can only move either down or right at any point in time. 
 Given the two integers m and n, return the number of possible unique paths that 
 the robot can take to reach the bottom - right corner.
 */

package dynamicProgram;

public class codeSeven {
	
	public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill first row and first column with 1s
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the rest of dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    // Example usage
    public static void main(String[] args) {
    	codeSeven solver = new codeSeven();
        System.out.println(solver.uniquePaths(3, 7)); // Output: 28
    }

}
