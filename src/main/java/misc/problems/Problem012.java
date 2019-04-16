package misc.problems;

public class Problem012 {

  public static int dp[][];

  /**
   * This is a simple recursion problem where we memoize the result.
   */
  public static int findPath(int arr[][], int row, int col, int m, int n) {
    if(m == row && n == col) return 1;
    if(row > m || col > n) return 0;

    if(dp[row][col] != -1) return dp[row][col];

    int rightDirection = findPath(arr, row, col + 1, m, n);
    int downDirection = findPath(arr, row + 1, col, m, n);
    int res = rightDirection + downDirection;
    dp[row][col] = res;
    return res;
  }

  public static void util(int m, int n) {
    int arr[][] = new int[m][n];
    dp = new int[m][n];

    for(int i=0; i < m; i++)
      for(int j=0; j < n; j++)
        dp[i][j] = -1;

    int totalPath = findPath(arr, 0, 0, m - 1, n - 1);
    System.out.println("The total path to traverse from top left to bottom right in "+m+" x "
        +n+" matrix is " + totalPath);
  }

  /**
   * This is another really short method that takes O(n^2) time and constant space.
   */

  public static void optimizeFindPath(int m, int n) {
    int mm[] = new int[n];
    mm[0] = 1;

    for(int i=0; i < m; i++) {
      for(int j=1; j < n; j++) {
        mm[j] = mm[j] + mm[j-1];
      }
    }
    System.out.println("The total path to traverse from top left to bottom right in "+m+" x "
        +n+" matrix is " + mm[n-1]);
  }

  public static void main(String[] args) {
    util(2, 2);
    util(3, 3);
    util(2, 3);
    optimizeFindPath(2, 3);
  }

}
