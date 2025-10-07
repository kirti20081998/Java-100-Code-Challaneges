/*
 An image is represented by an m X n integer grid image where image[i][j] represents the pixel value of the 
 image. You are also given three integers sr, sc, and color. You should perform a flood fill on the image 
 starting from the pixel image[sr][sc].
 */

package graphProgram;

public class codeThird {
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image; // no change needed

        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Base case: out of bounds or not the same color
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        if (image[r][c] != originalColor) return;

        // Change color
        image[r][c] = newColor;

        // Explore 4-directionally
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
    }

    // Example usage
    public static void main(String[] args) {
    	codeThird solver = new codeThird();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = solver.floodFill(image, sr, sc, newColor);

        // Print result
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
