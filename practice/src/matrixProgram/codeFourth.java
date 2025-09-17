/* Given an m X n integer matrix, if an element is 0, set its entire row and column to 0's. You must do it 
 in place.*/

package matrixProgram;

public class codeFourth {
	
	public static void main(String[] args) {
	    int[][] matrix = {
	        {1, 1, 1},
	        {1, 0, 1},
	        {1, 1, 1}
	    };

	    System.out.println("Original Matrix:");
	    printMatrix(matrix);

	    setZeroes(matrix);

	    System.out.println("\nModified Matrix:");
	    printMatrix(matrix);
	}

	public static void setZeroes(int[][] matrix) {
	    int rows = matrix.length;
	    int cols = matrix[0].length;

	    boolean firstRowZero = false;
	    boolean firstColZero = false;

	    // Step 1: Check if first row has zero
	    for (int j = 0; j < cols; j++) {
	        if (matrix[0][j] == 0) {
	            firstRowZero = true;
	            break;
	        }
	    }

	    // Step 2: Check if first column has zero
	    for (int i = 0; i < rows; i++) {
	        if (matrix[i][0] == 0) {
	            firstColZero = true;
	            break;
	        }
	    }

	    // Step 3: Use first row and column as markers
	    for (int i = 1; i < rows; i++) {
	        for (int j = 1; j < cols; j++) {
	            if (matrix[i][j] == 0) {
	                matrix[i][0] = 0;
	                matrix[0][j] = 0;
	            }
	        }
	    }

	    // Step 4: Set matrix cells to 0 using markers
	    for (int i = 1; i < rows; i++) {
	        for (int j = 1; j < cols; j++) {
	            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }

	    // Step 5: Zero the first row if needed
	    if (firstRowZero) {
	        for (int j = 0; j < cols; j++) {
	            matrix[0][j] = 0;
	        }
	    }

	    // Step 6: Zero the first column if needed
	    if (firstColZero) {
	        for (int i = 0; i < rows; i++) {
	            matrix[i][0] = 0;
	        }
	    }
	}

	public static void printMatrix(int[][] matrix) {
	    for (int[] row : matrix) {
	        for (int val : row) {
	            System.out.print(val + " ");
	        }
	        System.out.println();
	    }
	}

}
