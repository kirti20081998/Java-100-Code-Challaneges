/*
 Given an array of integers temperatures represents the daily temperatures, return an array such that 
 answers[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
 If there is no future day for which this is possible, keep answer[i] == 0 instead. 
*/

package stackQueueProgram;

import java.util.Stack;

public class codeThird {
	
	public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return ans;
    }

    // Example usage
    public static void main(String[] args) {
    	codeThird dt = new codeThird();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(temps);

        for (int r : result) {
            System.out.print(r + " ");
        }
        // Output: 1 1 4 2 1 1 0 0
    }

}
