package dp.classical;

public class Problem09 {

  public static void knapsack(int weights[], int values[], int W) {
    int n = weights.length;
    int dp[][] = new int[n + 1][W + 1];

    for(int i=0; i < n + 1; i++) dp[i][0] = 0;
    for(int i=0; i < W + 1; i++) dp[0][i] = 0;

    for(int item = 1; item <= n; item++) {
      for(int capacity = 1; capacity <= W; capacity++) {

        int valWithoutCurr = dp[item-1][capacity];
        int valWithCurr = 0;
        int currWeight = weights[item - 1];

        if(currWeight <= capacity) {
          valWithCurr = values[item - 1];
          int remainingCapacity = capacity - currWeight;
          valWithCurr = valWithCurr + dp[item - 1][remainingCapacity];
        }
        dp[item][capacity] = Math.max(valWithCurr, valWithoutCurr);
      }
    }

    System.out.println(dp[n][W]);
  }

  public static void main(String[] args) {
    knapsack(new int[]{1,2,3}, new int[]{6,10,12}, 5);
  }
}
