/*
 Given an m X n integers matrix, return the length of the longest increasing path in matrix. 
 From each cell, you can either move in four directions: left, right, up, or down. 
 You may not move daigonally or move outside the boundary(i.e wrap-aroound is not allowed)
 */

package graphProgram;

public class codeFour {
	
	private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n]; // memoization table
        int maxPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, dp);
                maxPath = Math.max(maxPath, len);
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j]; // already computed

        int maxLen = 1; // at least the cell itself
        for (int[] dir : directions) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[i][j]) {
                int len = 1 + dfs(matrix, r, c, dp);
                maxLen = Math.max(maxLen, len);
            }
        }

        dp[i][j] = maxLen; // store result
        return maxLen;
    }

    // Example usage
    public static void main(String[] args) {
    	codeFour solver = new codeFour();
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        System.out.println(solver.longestIncreasingPath(matrix)); // Output: 4
    }

}
