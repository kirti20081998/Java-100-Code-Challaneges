/*Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target  in nums.
If target exists, then return its index. Otherwise, return -1. You must write an algorithm with O(log n) runtime complexity.*/

package sortingprogram;

public class codeone {
    // Binary Search
    public static int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return -1;
    }
    public static void main(String[] args){
        int[] nums = {-10, -3, 0, 5, 9};
        int target = 5;

        int result = search(nums, target);
        System.out.println("Index of target: " + result);
    }
	
}
