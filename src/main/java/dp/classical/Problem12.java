package dp.classical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem12 {

  /**
   * No of ways in which we can form a change for a given sum from infinite number of coins.
   */
  private int noOfWaysRecur(int index, int sum, int target, int arr[]) {
    if(sum == target) {
      return 1;
    }
    if(sum > target) return 0;

    int result = 0;
    for(int i=index; i < arr.length; i++) {
      result = result + noOfWaysRecur(i, sum + arr[i], target, arr);
    }
    return result;
  }

  /**
   * Memoization technique does not work here. We are not identifying min or max values. But we are trying out all
   * possible combinations.
   */
  private int noOfWaysDp(int index, int sum, int target, int arr[], Map<String, Integer> dp) {
    if(sum == target) {
      return 1;
    }
    if(sum > target) return 0;
    String key = index + " : " + sum;
    if(dp.containsKey(key)) return dp.get(key);

    int result = 0;
    for(int i=index; i < arr.length; i++) {
      result = result + noOfWaysDp(i, sum + arr[i], target, arr, dp);
    }
    dp.put(key, result);

    return result;
  }


  /**
   * Minimum number of changes required to form a given sum.
   */

  private int minWaysRecur(int index, int sum, int target, int arr[]) {
    if(sum == target) return 0;
    if(sum > target) return Integer.MAX_VALUE - 12345;
    //We are deducting some values from MAX because we are adding 1 on our result. Now if we add 1 to MAX_VAL then it
    //becomes -ve and changes our expected result;

    int result = Integer.MAX_VALUE - 12345;
    for(int i=index; i < arr.length; i++) {
      result = Math.min(result, minWaysRecur(index, sum + arr[i], target, arr));
    }
    return result + 1;
  }


  private int minWaysDp(int index, int sum, int target, int arr[], Map<String, Integer> dp) {
    if(sum == target) return 0;
    if(sum > target) return Integer.MAX_VALUE - 12345;
    String key = index + ":" + sum;
    if(dp.containsKey(key)) return dp.get(key);

    //We are deducting some values from MAX because we are adding 1 on our result. Now if we add 1 to MAX_VAL then it
    //becomes -ve and changes our expected result;

    int result = Integer.MAX_VALUE - 12345;
    for(int i=index; i < arr.length; i++) {
      result = Math.min(result, minWaysDp(index, sum + arr[i], target, arr, dp));
    }
    dp.put(key, result + 1);
    return result + 1;
  }


  private void util(int[] coins, int target) {
    System.out.println("Coins: " + Arrays.toString(coins));
    System.out.println("Sum: " + target);
    int result;
    result = noOfWaysRecur(0, 0, target, coins);
    System.out.println("No of ways in which we can form a change (Recursion): " + result);

    result = noOfWaysDp(0, 0, target, coins, new HashMap<>());
    System.out.println("No of ways in which we can form a change (DP): " + result);

    result = minWaysRecur(0, 0, target, coins);
    System.out.println("Minimum number of ways in which we can form a sum from a change (Recursion): " + result);

    result = minWaysDp(0, 0, target, coins, new HashMap<>());
    System.out.println("Minimum number of ways in which we can form a sum from a change (DP): " + result);

    System.out.println("\n");

  }

  public static void main(String[] args) {
    Problem12 object = new Problem12();
    int sum = 0;
    int [] coins = new int[0];

    coins = new int[]{1,3};
    sum = 4;
    object.util(coins, sum);


    coins = new int[]{3,5,6};
    sum = 11;
    object.util(coins, sum);

    coins = new int[]{2,3,5};
    sum = 10;
    object.util(coins, sum);


    coins = new int[]{2,3,5};
    sum = 20;
    object.util(coins, sum);


  }


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

}
