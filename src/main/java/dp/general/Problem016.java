package dp.general;

import java.util.Arrays;

public class Problem016 {

  /**
   * Solving by recursion, top down approach. Always try this recursion approach and then go with
   * iteration. We have to add dp table to optimize the time complexity.
   */
  public static int maxSumRecur(int arr[], int i) {
    if(i < 0) return 0;
    if(i == 0) return arr[0];
    if(i == 1) return Math.max(arr[0], arr[1]);

    int includeIthElement = arr[i] + maxSumRecur(arr, i-2);
    int excludeIthElement = maxSumRecur(arr, i-1);
    return Math.max(includeIthElement, excludeIthElement);
  }

  /**
   * Solving by iteration. Bottom up approach.
   */
  public static void maxSumIter(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int dp[] = new int[arr.length];
    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);

    for(int i=2; i <= arr.length - 1; i++) {
      dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
    }

    System.out.println("Max subsequence sum by Iteration " + dp[arr.length - 1] + "\n");
  }

  public static void maxSumRecurUtil(int arr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println("Max subsequence sum by Recursion " + maxSumRecur(arr, arr.length - 1) +
        "\n");
  }

  public static void main(String[] args) {
    maxSumRecurUtil(new int[]{5, 5, 10, 100, 10, 5});
    maxSumRecurUtil(new int[]{20, 1, 2, 3});

    maxSumIter(new int[]{5, 5, 10, 100, 10, 5});
    maxSumIter(new int[]{20, 1, 2, 3});

  }

}
