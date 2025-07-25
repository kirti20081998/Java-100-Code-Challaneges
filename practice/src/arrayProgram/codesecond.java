/*Given an Integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.Note that you must do 
this in-place without making a copy of the array.*/
package arrayProgram;

public class codesecond {
	public void moveZeroes(int[] nums) {
		
		int insertPos = 0;
		
		// First, move all non-zero elements to the front
		for(int num: nums) {
			if(num != 0) {
				nums[insertPos++] = num;
			}
		}
		
		// Then, fill the remaining positions with zeros
		while(insertPos < nums.length) {
			nums[insertPos++] = 0;
		}
	}
	
	// Optional main method for testing
	public static void main(String[] args) {
		codesecond obj = new codesecond();
		int[] nums = {0, 1, 0, 3, 12};
		obj.moveZeroes(nums);
		
		for(int num: nums) {
			System.out.print(num + " ");
		}
	}
}
