/*You are given an integer array height of length n.There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and
  (i, height[i]).Find two lines that together with the x-axis form a container, such that the container contains the most water. Return the maximum 
  amount of water a container can store.*/

package arrayProgram;

public class codesixth {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0, right = height.length - 1;

		// Two-pointer approach
		while (left < right) {
			int width = right - left;
			int h = Math.min(height[left], height[right]);
			int area = width * h;

			// Update max area if current one is larger
			maxArea = Math.max(maxArea, area);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	// Optional main method for testing
	public static void main(String[] args) {
		codesixth obj = new codesixth();
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = obj.maxArea(height);
		System.out.println("Maximum Water Container Area: " + result);
	}
}
