/*
 You are given an integer array coins representing coins of different denominations and an integer amount 
 representing a total amount of money. Return the fewest number of coins that you need to make up that 
 amount. If that amount of money cannot be made up by any combinations of coins, return -1. You may assume 
 that you have an infinite number of each kind of coin.
 */

package dynamicProgram;

import java.util.Arrays;

public class codeFour {
	
	public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // represents unreachable state
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Example usage
    public static void main(String[] args) {
    	codeFour solver = new codeFour();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(solver.coinChange(coins, amount)); // Output: 3 (5+5+1)
    }

}
