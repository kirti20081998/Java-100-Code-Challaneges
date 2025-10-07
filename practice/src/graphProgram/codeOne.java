/*
 Given an m x n 2D binary grid grid which represents a map of '1's(land) and '0's(water) , 
 return the number of islands. An island is surrounded by water and is formed by connecting adjacent lands 
 horizentally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

package graphProgram;

public class codeOne {
	
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return islandCount;
    }

    // DFS to mark connected land
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // Base case: out of bounds or already visited/water
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;

        grid[i][j] = '0'; // mark as visited

        // Explore 4 directions
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }

    // Example usage
    public static void main(String[] args) {
    	codeOne solver = new codeOne();
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(solver.numIslands(grid)); // Output: 3
    }

}
