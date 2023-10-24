package dp.classical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Ref: https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 *
 * The recursive approach is to generate all possible sums from all the values of array and to check
 * which solution is the most optimal one.
 * To generate sums we either include the i’th item in set 1 or don’t include, i.e., include in
 * set 2.
 *
 * The time complexity is O(n*sum) for both time and space.
 */
public class Problem16 {

  static int dp[][];
  public static int minDiffSubsets(int arr[], int i, int calculatedSum, int totalSum) {

    if(dp[i][calculatedSum] != -1) return dp[i][calculatedSum];

    /**
     * If i=0, then the sum of one subset has been calculated as we have reached the last
     * element. The sum of another subset is totalSum - calculated sum. We need to return the
     * difference between them.
     */
    if(i == 0) {
      return Math.abs((totalSum - calculatedSum) - calculatedSum);
    }

    //Including the ith element
    int iElementIncluded = minDiffSubsets(arr, i-1, arr[i-1] + calculatedSum,
        totalSum);

    //Excluding the ith element
    int iElementExcluded = minDiffSubsets(arr, i-1, calculatedSum, totalSum);

    int res = Math.min(iElementIncluded, iElementExcluded);
    dp[i][calculatedSum] = res;
    return res;
  }

  public static void util(int arr[]) {
    int totalSum = 0;
    int n = arr.length;
    for(Integer e : arr) totalSum += e;
    dp = new int[n+1][totalSum+1];
    for(int i=0; i <= n; i++)
      for(int j=0; j <= totalSum; j++)
        dp[i][j] = -1;

    int res = minDiffSubsets(arr, n, 0, totalSum);
    System.out.println("The min difference between two subset is " + res);
  }


  /**
   * The logic is again simple. We calculate the a sum of a random subset. The total sum of an array minus this
   * sub set sum will give me the sum of an another subset. The difference between the two is a potential answer.
   * And the min diff is the expected answer.
   */
  private static int count = 0;
  private static int minDiff = Integer.MAX_VALUE;
  private void recur(int index, int sum, int arr[], int total, Map<String, Integer> dp) {
    if(index > arr.length) return;
    String key = index + " : " + sum;
    if(dp.containsKey(key)) return;

    int sumSet1 = sum;
    int sumSet2 = Math.abs(total - sum);
    int diff = Math.abs(sumSet1 - sumSet2);
    minDiff = Math.min(minDiff, diff);

    count++;
    for(int i=index; i < arr.length; i++) {
      recur(i + 1, sum + arr[i], arr, total, dp);
    }
    dp.put(key, diff);
  }




  private void utils(int arr[]) {
    int S = 0;
    for(int i=0;  i< arr.length; i++) S = S + arr[i];
    minDiff = Integer.MAX_VALUE;
    count=0;
    System.out.println(Arrays.toString(arr));

    recur(0, 0, arr, S, new HashMap<>());
    System.out.println("Min subset diff: " + minDiff);
    System.out.println("Count: " + count);
    System.out.println("\n");
  }

  public static void main(String[] args) {
    //util(new int[]{3, 1, 4, 2, 2, 1});
    Problem16 object = new Problem16();
    int arr[];

    arr = new int[]{1,2,3};
    object.utils(arr);

    arr = new int[]{2,3};
    object.utils(arr);

    arr = new int[]{2,5,8,9,100};
    object.utils(arr);

  }



}
