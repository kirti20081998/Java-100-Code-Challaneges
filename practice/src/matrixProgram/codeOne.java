/*Given an m X n matrix, return all elements of the matrix in spiral order*/

package matrixProgram;

import java.util.ArrayList;
import java.util.List;

public class codeOne {
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++; // move down

            // Traverse from top to bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // move left

            if (top <= bottom) {
                // Traverse from right to left
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // move up
            }

            if (left <= right) {
                // Traverse from bottom to top
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // move right
            }
        }

        return result;
    }

    public static void main(String[] args) {
    	codeOne sm = new codeOne();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> spiral = sm.spiralOrder(matrix);
        System.out.println("Spiral order: " + spiral);
    }

}
