/*Given two sorted arrays nums1 and nums2 of size m and n respectivly, return the median of the two sorted arrays.
  The overall run time complexity should be O(log(m+n))
 */
package sortingAndRecursionProgram;

public class codethird {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightX && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {

                high = partitionX - 1;
            } else {

                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or invalid");
    }

    public static void main(String[] args) {
        codethird solution = new codethird();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median is: " + solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

    }

}
