package dp.classical;

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

  public static void main(String[] args) {
    System.out.println(diceSum(3, 6, 12));
  }
}
