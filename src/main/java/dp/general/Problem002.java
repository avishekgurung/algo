package dp.general;

public class Problem002 {

  public static int tiling(int n) {
    if(n == 0 || n == 1) return 1;
    return tiling(n - 1) + tiling(n - 2);
  }

  public static int tilingDp(int n) {
    int dp[] = new int[n + 1];
    dp[0] = dp[1] = 1;
    for(int i=2; i <=n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(tiling(5));
    System.out.println(tilingDp(5));
  }

}
