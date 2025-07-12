// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. 

package arrayprogram;

public class codeone {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] answer = new int[n];

		answer[0] = 1;
		for (int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] * nums[i - 1];
		}

		int suffix = 1;
		for (int i = n - 1; i >= 0; i--) {
			answer[i] = answer[i] * suffix; //answer[i] *= suffix
			suffix = suffix *  nums[i];     //suffix *= nums[i]
		}

		return answer;
	}

	public static void main(String args[]) {
		codeone obj = new codeone();
		int[] nums = { 1, 2, 3, 4 };
		int[] result = obj.productExceptSelf(nums);
		for (int val : result) {
			System.out.print(val + " ");
		}

	}

}
