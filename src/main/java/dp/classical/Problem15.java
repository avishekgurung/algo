package dp.classical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem15 {

  static int dp[][] = new int[1000][1000];
  static int count = 0;

  public static int diceSum(int n, int k, int sum) {
    if(n == 0) return sum;

    if(dp[n][sum] != 0) return dp[n][sum];

    //System.out.println("count = " + count++);
    /**
     * If sum is less than 0 then return 0.
     *
     * If there are n dice and each dice value ranges from 1 to k. Then the maximum values we can
     * get in a throw is nk. If sum > nk then its a erroneous case where we return 0.
     *
     * If there are n dice and each dice value ranges from 1 to k. Then the minimum values we can
     * get in a throw is n * 1 = n. If sum < n then its a erroneous case where we return 0.
     *
     */
    if (sum < 0 || k * n < sum || sum < n)
      return 0;

    int res = 0;

    // recurse for all possible solutions
    for (int i = 1; i <= k; i++)
      res += diceSum(n - 1, k, sum - i);

    dp[n][sum] = res;
    return res;
  }

  /**
   * This again is one of the simplest problem. Let's say 3 dices are provided with 3 faces each. Then we can think
   * of this as
   * [[1,2,3], [1,2,3], [1,2,3]]
   *
   * Now if a sum S is provided then we will have to use the element of each array and check of their sum total is
   * equal to S. This is just a tweak of a phone key button problem
   * (https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-interview-150)
   */
  private int recur(int index, int sum, int target, int arr[][]) {
    if(sum == target) return 1;
    if(sum > target) return 0;
    if(index >= arr.length) return 0;

    int result = 0;

    int aux[] = arr[index];
    for(int i=0; i < aux.length; i++) {
      result = result + recur(index + 1, sum + aux[i], target, arr);
    }
    recurExCount++;
    return result;
  }

  private int recurDp(int index, int sum, int target, int arr[][], Map<String, Integer> dp) {
    if(sum == target) return 1;
    if(sum > target) return 0;
    if(index >= arr.length) return 0;

    String key = index + ":" + sum;
    if(dp.containsKey(key)) return dp.get(key);

    int result = 0;

    int aux[] = arr[index];
    for(int i=0; i < aux.length; i++) {
      result = result + recurDp(index + 1, sum + aux[i], target, arr, dp);
    }
    dp.put(key, result);
    dpExCount++;
    return result;
  }


  private static int recurExCount = 0;
  private static int dpExCount = 0;


  private void util(int n, int m, int S) {
    dpExCount = 0;
    recurExCount = 0;

    int arr[][] = new int[n][m];
    for(int i=0; i < n; i++)
      for(int j=0; j < m; j++)
        arr[i][j] = j+1;


    System.out.println("Faces: " + m + ", Counts: " + n + ", Sum: " + S);
    for(int i=0; i < n; i++)
      System.out.println(Arrays.toString(arr[i]));
    System.out.println("No of ways (Recur): " + recur(0, 0, S, arr));
    System.out.println("No of ways (Dp): " + recurDp(0, 0, S, arr, new HashMap<>()));
    System.out.println("Execution count: Recur=" + recurExCount+ ", Dp=" + dpExCount);
    System.out.println("\n");


  }

  public static void main(String[] args) {
    //System.out.println(diceSum(3, 6, 12));
    Problem15 object = new Problem15();
    int n,m,S;

    n = 2;
    m = 6;
    S = 10;
    object.util(n, m, S);


    n = 2;
    m = 6;
    S = 6;
    object.util(n, m, S);


    n = 4;
    m = 6;
    S = 10;
    object.util(n, m, S);

    n = 10;
    m = 6;
    S = 10;
    object.util(n, m, S);
  }
}
