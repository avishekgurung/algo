package dp.classical;

/**
 * Ref: https://www.youtube.com/watch?v=3hNuefaICxw
 */
public class Problem08 {
  static int dp[][];

  public static int optimalGameStrategy(int arr[], int i, int j) {
    //If one single element then choose that.
    if(i == j) return arr[i];

    //If only two elements then choose the max.
    if (i + 1 == j ) return Math.max(arr[i], arr[j]);

    //If the result is already computed, then return that.
    if(dp[i][j] != -1) return dp[i][j];

    /**
     * If I choose i, then the array length will shrink to i+1 to j.
     * The next move is of the opponent. And whatever he choose, I would want the result to be
     * minimum. If he choose j, then array will shrink to i+1, j-1. But if also choose i then
     * array will shrink to i+2,j. Whatever he choose, I want the result to be min, hence I take
     * the minimum of his two choices.
     *
     * Similarly for a case, when I choose j.
     *
     * I will eventually take the maximum of both of my case. :)
     */
    int iChooseI = arr[i] + Math.min(optimalGameStrategy(arr, i+1, j-1),
        optimalGameStrategy(arr, i+2, j));
    int iChooseJ = arr[j] + Math.min(optimalGameStrategy(arr, i+1, j-1),
        optimalGameStrategy(arr, i, j-2));
    int res = Math.max(iChooseI, iChooseJ );
    dp[i][j] = res;
    return res;
  }


  public static void main(String[] args) {
    int[] arr = new int[]{5,3,7,10};
    dp = new int[arr.length][arr.length];
    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr.length; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println( " Nas: " + optimalGameStrategy(arr, 0, arr.length-1));
  }
}
