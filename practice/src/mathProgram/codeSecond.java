/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n) , 
 * ans[i] is the number of 1's in the binary representation of i.*/

package mathProgram;

import java.util.Arrays;

public class codeSecond {
	
	public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0; // base case

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    // Example usage
    public static void main(String[] args) {
    	codeSecond solution = new codeSecond();

        int n = 5;
        int[] result = solution.countBits(n);

        System.out.println("Bits count up to " + n + ": " + Arrays.toString(result));
        // Output: [0, 1, 1, 2, 1, 2]
    }

}
