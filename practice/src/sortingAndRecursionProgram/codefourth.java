/* Given an Integer array nums and an integer k, return the kth largest element in the array.
  Note that it is the kth largest element in the sorted order, not the kth distinct element.
  You must solve it in O(n) time complexity.
 */
package sortingAndRecursionProgram;

import java.util.Random;

public class codefourth {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // kth largest is (n - k)th smallest in 0-based indexing
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }

        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);

        pivotIndex = partition(nums, left, right, pivotIndex);

        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        // Move pivot to end
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // Move smaller elements to the left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        codefourth solution = new codefourth();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth largest element is: " + solution.findKthLargest(nums, k));  // Output: 5

    }

}
