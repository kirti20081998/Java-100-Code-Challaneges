/*Given an array nums with n objetcs colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the 
  colors in the red, white, and blue.
  Referring to the classic "Sort Colors" problem (also known as the Dutch National Flag problem). The values typically are represented as:
	0 → red
	1 → white
	2 → blue
  Need to sort the array in-place so that all 0s come first, followed by 1s, then 2s.*/
package arrayprogram;

public class codeseventh {
	codefourth obj = new codefourth();
	public void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		
		 // Dutch National Flag algorithm
		while(mid <= high) {
			if(nums[mid] == 0) {
				obj.swap(nums, low++, mid++);
			}else if(nums[mid] == 1) {
				mid++;
			}else {  // nums[mid] == 2
				obj.swap(nums, mid, high--);
			}
		}
	}
	
	public static void main(String[] args) {
		codeseventh sc = new codeseventh();
		int[] nums = {2, 0, 2, 1, 1, 0};
		sc.sortColors(nums);
		
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
