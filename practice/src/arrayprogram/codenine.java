/* You are given two integer arrays nums1 and nums2, sorted in non - decreasing order, and two integers m and n, representing the number of elements 
  in nums1 and nums2 respectively. Merge nums1 and nums2 into a single array sorted in non-decreasing order. */
package arrayprogram;

import java.util.Arrays;

public class codenine {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;// pointer for nums1
		int p2 = n - 1;// pointer for nums2
		int p = m + n - 1; // pointer for merged result in nums1

		// Merge from the end
		while (p1 >= 0 && p2 >= 0) {
			if (nums1[p1] > nums2[p2]) {
				nums1[p--] = nums1[p1--];
			} else {
				nums1[p--] = nums2[p2--];
			}
		}

		// If any elements left in nums2
		while (p2 >= 0) {
			nums1[p--] = nums2[p2--];
		}
	}

	public static void main(String[] args) {
		codenine merger = new codenine();
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3, n = 3;

		merger.merge(nums1, m, nums2, n);
		System.out.println("Merged Array: " + Arrays.toString(nums1));
	}
}
