package array.problems;

import java.util.Arrays;

public class  Problem053 {

  public static void maxSumWithNoElementAdjacent(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int prevMaxSum = arr[0];
    int currMaxSum = 0;
    int maxSum = 0;

    for (int i = 1; i < arr.length; i++) {
      currMaxSum += arr[i];
      maxSum = Math.max(prevMaxSum, currMaxSum);
      currMaxSum = prevMaxSum;
      prevMaxSum = maxSum;
    }
    System.out.println("Max sum: " + maxSum + "\n");
  }

  /**
   * DP approach.
   * @param arr
   */
  public static void maxSum(int arr[]) {
    int n = arr.length;
    int dp[] = new int[n];
    dp[0] = arr[0]; //if only one element that that is the max element
    dp[1] = Math.max(arr[0], arr[1]); //if only two elements then max of both.

    for(int i=2; i < n; i++) {
      dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
    }
    System.out.println("dp = " + Arrays.toString(dp)+"\n---------------------------------");
  }

  public static void main(String[] args) {
    maxSumWithNoElementAdjacent(new int[]{1, 2, 3, 4, 5});
    maxSum(new int[]{1, 2, 3, 4, 5});

    maxSumWithNoElementAdjacent(new int[]{5, 5, 10, 100, 10, 5});
    maxSum(new int[]{5, 5, 10, 100, 10, 5});


    maxSumWithNoElementAdjacent(new int[]{1, 2, 3});
    maxSum(new int[]{1, 2, 3});

    maxSumWithNoElementAdjacent(new int[]{1, 20, 3});
    maxSum(new int[]{1, 20, 3});

    maxSumWithNoElementAdjacent(new int[]{8,6,30,5,10,100});
    maxSum(new int[]{8,6,30,5,10,100});
  }

}
