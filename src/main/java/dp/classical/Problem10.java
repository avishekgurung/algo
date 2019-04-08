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
    int price[] = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, -1};
    int n = 4;

    System.out.println("Rod length:" + n + ", Max Revenue: " + topDownRecursion(price, n));

    System.out.println("Rod length:" + n + ", Max Revenue: " +
        topDownMemoized(price, n , new HashMap<Integer, Integer>()));

    System.out.println("Rod length:" + n + ", Max Revenue: " + bottomUp(price, n));

    bottomUpWithCutDetails(price, n);

  }

}
