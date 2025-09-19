package mathProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class codeFourth {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count elements in nums1
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Check against nums2
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        // Convert List to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // Example usage
    public static void main(String[] args) {
    	codeFourth solution = new codeFourth();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("Intersection: " + Arrays.toString(solution.intersect(nums1, nums2)));
        // Output: [2, 2]

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println("Intersection: " + Arrays.toString(solution.intersect(nums3, nums4)));
        // Output: [9, 4] or [4, 9] (order doesn’t matter)
    }

}
