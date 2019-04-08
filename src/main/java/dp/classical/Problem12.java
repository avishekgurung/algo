package dp.classical;

import java.util.Arrays;

public class Problem12 {

  public static void coinChange(int coins[], int sum) {

    System.out.println("Coins: " + Arrays.toString(coins));
    System.out.println("Sum: " + sum);

    int dp[] = new int[sum + 1];

    /**
     * Base condition: If the sum provided is 0 and we have coins then there is one solution,
     * which is to not include any coin.
     */
    dp[0] = 1;

    for(int i=0; i < coins.length; i++) {
      int currentCoin = coins[i];

      for(int j=currentCoin; j <= sum; j++) {
        dp[j] = dp[j] + dp[j - currentCoin];
      }
    }

    System.out.println("The maximum unique ways to create a sum is " + dp[sum]);
    System.out.println();
  }

  public static void main(String[] args) {
    coinChange(new int[]{1,2,3}, 4);
    coinChange(new int[]{1,2}, 4);
    coinChange(new int[]{2,3,5,6}, 10);
  }
}
