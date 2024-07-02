package dp.classical;

import java.util.*;

/**
 * Ref: https://www.youtube.com/watch?v=s6FhG--P7z0&t=481s
 */
public class Problem07 {

  public static void main(String[] args) {

    int arr[] = {1,2,3};
    int targets[] = {6};
    System.out.println(Arrays.toString(arr));

    System.out.println("Result from recursion");
    for(Integer target : targets) {
      boolean result = recur(0, 0, arr, target);
      System.out.println("Target: " + target + ", result: " +result);
    }

    System.out.println("\nResult from DP");
    for(Integer target : targets) {
      boolean result = recurDp(0, 0, arr, target, new HashMap<>());
      System.out.println("Target: " + target + ", result: " +result);
    }

  }

  /**
   * It should be noted that when we find an answer of one index, it is not necessary to calculate it again, so we can
   * memoize it. Eg, in [1,2,3] if the target = 3 then if at any point of time, we reach 3 then we can just return the
   * response and avoid further calculation to reduce repeated sub-problem calculation.
   */
  private static boolean recurDp(int sum, int index, int arr[], int target, Map<Integer, Boolean> dp) {
    if(sum == target) return true;
    if(sum > target) return false;
    if(index >= arr.length) return false;
    if(dp.get(index) != null) return dp.get(index);

    boolean result = false;
    for(int i=index; i < arr.length; i++) {
      result = result || recurDp(sum + arr[i], i+1, arr, target, dp);
    }
    dp.put(index, result);
    return result;
  }

  private static boolean recur(int sum, int index, int arr[], int target) {
    if(sum == target) return true;
    if(sum > target) return false;
    if(index >= arr.length) return false;

    boolean result = false;
    for(int i=index; i < arr.length; i++) {
      result = result || recur(sum + arr[i], i+1, arr, target);
    }
    return result;
  }

}
