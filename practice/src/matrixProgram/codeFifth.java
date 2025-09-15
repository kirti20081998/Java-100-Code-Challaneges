/* Given an m X n binary matrix mat, return the distance of the nearest 0 for each cell. 
   The distance between two adjacent cells is 1*/

package matrixProgram;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class codeFifth {
	
	public static void main(String[] args) {
	    int[][] mat = {
	        {0, 0, 0},
	        {0, 1, 0},
	        {1, 1, 1}
	    };

	    int[][] result = updateMatrix(mat);

	    System.out.println("Distance Matrix:");
	    for (int[] row : result) {
	        System.out.println(Arrays.toString(row));
	    }
	}

	public static int[][] updateMatrix(int[][] mat) {
	    int rows = mat.length;
	    int cols = mat[0].length;

	    int[][] dist = new int[rows][cols];
	    boolean[][] visited = new boolean[rows][cols];
	    Queue<int[]> queue = new LinkedList<>();

	    // Step 1: Add all 0s to the queue
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            if (mat[i][j] == 0) {
	                queue.offer(new int[]{i, j});
	                visited[i][j] = true;
	            }
	        }
	    }

	    // Step 2: BFS to fill distances
	    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	    while (!queue.isEmpty()) {
	        int[] cell = queue.poll();
	        int x = cell[0], y = cell[1];

	        for (int[] dir : directions) {
	            int nx = x + dir[0];
	            int ny = y + dir[1];

	            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
	                dist[nx][ny] = dist[x][y] + 1;
	                visited[nx][ny] = true;
	                queue.offer(new int[]{nx, ny});
	            }
	        }
	    }

	    return dist;
	}

}
