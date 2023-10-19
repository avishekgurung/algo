package dp.classical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem10 {
  /**
   * Ref: CLRS
   */

  /**
   * Top down recursion without using DP.
   * It has time complexity of 2^n  which is very very high.
   * It does lot of re-computation of sub-problems.
   * @param price
   * @param n
   */
  public static int topDownRecursion(int price[], int n) {
    if(n == 0) return 0;
    int maxPrice = Integer.MIN_VALUE;
    for(int i=1; i <= n; i++) {
      maxPrice = Math.max(maxPrice, price[i] + topDownRecursion(price, n - i));
    }
    return maxPrice;
  }

  /**
   * This is a top down approach which would take O(n2).
   * @param price
   * @param n
   * @return
   */
  public static int topDownMemoized(int price[], int n, Map<Integer, Integer> memoized) {
    if(memoized.get(n) != null) return memoized.get(n);
    if(n == 0) {
      memoized.put(0, 0);
      return 0;
    }
    int maxSum = Integer.MIN_VALUE;
    for(int i=1; i <= n; i++) {
      maxSum = Math.max(maxSum, price[i] + topDownMemoized(price, n - i, memoized));
    }
    memoized.put(n, maxSum);
    return maxSum;
  }

  /**
   * This is considered to be more efficent but has same time complexity.
   * @param price
   * @param n
   * @return
   */
  public static int bottomUp(int price[], int n) {
    Map<Integer, Integer> memoiz = new HashMap<Integer, Integer>();
    memoiz.put(0, 0);

    for(int i=1; i <= n; i++) {
      int maxSum = Integer.MIN_VALUE;
      for(int j=1; j <= i; j++) {
        maxSum = Math.max(maxSum, price[j] + memoiz.get(i - j));
      }
      memoiz.put(i, maxSum);
    }
    return memoiz.get(n);
  }

  public static void bottomUpWithCutDetails(int price[], int n) {
    Map<Integer, Integer> memoiz = new HashMap<Integer, Integer>();
    int[] cuts = new int[n + 1];
    memoiz.put(0, 0);

    for(int i=1; i <=n; i++) {
      int max = Integer.MIN_VALUE;
      for(int j=1; j <=i; j++) {
        int revenue = price[j] + memoiz.get(i-j);
        if(revenue > max) {
          max = revenue;
          cuts[j] = i;
        }
      }
      memoiz.put(i, max);
    }
    System.out.println("Rod length:" + n + ", Max Revenue: " + memoiz.get(n));

    System.out.println("Cut details: ");
    System.out.println(Arrays.toString(cuts));
  }

  public static void main(String[] args) {
    Problem10 object = new Problem10();

    int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
    int n = 8;
    object.util(price, n);

    price = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
    n = 8;
    object.util(price, n);
  }

  int maxProfit = Integer.MIN_VALUE;

  private void util(int price[], int n) {
    maxProfit = Integer.MIN_VALUE;
    int arr[] = new int[price.length];
    for(int i=0; i < arr.length; i++) arr[i] = i+1;
    recur(0, 0,0, n, arr, price);
    System.out.println("Length: " + n);
    System.out.println("Price: " + Arrays.toString(price));
    System.out.println("Maximum profit: " + maxProfit);
    System.out.println();
  }


  /**
   * This problem is just an extension of coin exchange problem. In a coin exchange problem, for a given sum,
   * we try to find the minimum number of denominations that we can select so that it is equal to a given sum.
   *
   * Here too, we do the same. For a given length of a rod, we try to find all the sub-arrays, that can sum up to a
   * given length. Once, we identify the sub-arrays, price is just about getting the maximum. Hence, the main focus
   * should be on finding the sub-arrays whose sum is equal to the length of the rod. The price is just for computation.
   *
   */
  private void recur(int index, int sum, int profit, int target, int arr[], int price[]) {
    if(sum == target) {
      maxProfit = Math.max(maxProfit, profit);
      return;
    }

    if(sum > target) return;

    for(int i=index; i < arr.length; i++) {
      recur(i, sum + arr[i], profit + price[i], target, arr, price);
    }
  }

}
