/*
 * You are given an m X n grid where each cell can have one of three values: 0 representing an empty cell, 
 * 1 representing a fresh orange, or 2 representing a rotten orange. Every minute, any fresh orange that 
 * is 4 - directionally adjacent to a rotten oranges becomes rotten. Return the minimum number of minutes 
 * that must elapse until no cell has a fresh orange.If this is impossible , return -1.
 */

package stackQueueProgram;

import java.util.LinkedList;
import java.util.Queue;

public class codeTen {
	
	public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: collect initial rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // no fresh oranges

        int minutes = -1; // we count after processing a level
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot it
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                    }
                }
            }
        }

        return (freshCount == 0) ? minutes : -1;
    }

    // Example usage
    public static void main(String[] args) {
    	codeTen solver = new codeTen();
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(solver.orangesRotting(grid)); // Output: 4
    }

}
