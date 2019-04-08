package dp.classical;

public class Problem11 {

  public static int waysToCoverADistance(int n) {
    int dp[] = new int[n + 1];

    dp[0] = 1; //if there is not distance, then we can cover the distance in one way i.e. don't
    // cover
    dp[1] = 1;
    dp[2] = 2;

    for(int i=3; i <=n; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }
    return dp[n];
  }

  public static void util(int n) {
    System.out.println("The number of ways to cover distance " + n + " is " +
        waysToCoverADistance(n));
  }

  public static void main(String[] args) {
    util(4);
    util(5);
    util(10);
  }
}
