package array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem060 {
  /**
   * We are going to divide the problem and solve it. Let the two arrays be
   * arr1[] = {0, 1, 0, 0, 0, 0};
   * arr2[] = {1, 0, 1, 0, 0, 1};
   *
   * 1. lets create a third array such that:
   * arr[i] = arr1[i] - arr2[i];
   * So arr = [-1, 1, -1, 0, 0, -1]
   *
   * 2. The longest subarray with same sum will now be the longest subarray with sum equal to 0.
   *
   * 3. But how do we find the longest subarray with sum equalt 0? We follow the approach to find
   * the all subarrays whose sum is equal to 0. We find all subarrays and take the longest one.
   *
   * This problem also allows us to fix another problem. Find the largest sub-array with equal
   * number of 0s and 1s when the array is binary. Here, well replace all zeroes by -1 and find
   * the largest array whose sum is equal to 0.
   *
   * The time complexity will be O(n) and space complexity will be O(n) for both the problems.
   */

  public static void longestSubArrayWithSameSum(int arr1[], int arr2[]) {
    int arr[] = new int[arr1.length];
    for(int i=0; i < arr.length; i++) {
      arr[i] = arr1[i] - arr2[i];
    }
    longestSubArrayWithSumEqualToZero(arr);
  }

  private static void longestSubArrayWithSumEqualToZero(int arr[]) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int sum = 0;
    int startIndex = 0, endIndex = -1;
    int maxLength = Integer.MIN_VALUE;

    for(int i=0; i < arr.length; i++) {
      sum = sum + arr[i];
      if(map.get(sum) != null) {
        int val = map.get(sum);
        int length = i - val;
        if(length > maxLength) {
          maxLength = length;
          startIndex = val + 1;
          endIndex = i;
        }
      }
      else {
        map.put(sum, i);
      }
    }

    if(maxLength == Integer.MIN_VALUE) {
      System.out.println("No result\n");
      return;
    }

    System.out.println("Longest Subarray: " + (endIndex - startIndex + 1) + " ["+startIndex+","+
        (endIndex) +"]\n");
  }

  public static void main(String[] args) {
    int  arr1[] = new int[]{0, 1, 0, 1, 1, 1, 1};
    int  arr2[] = new int[]{1, 1, 1, 1, 1, 0, 1};
    longestSubArrayWithSameSum(arr1, arr2);

    arr1 = new int[]{0, 1, 0, 0, 0, 0};
    arr2 = new int[]{1, 0, 1, 0, 0, 1};
    longestSubArrayWithSameSum(arr1, arr2);

    arr1 = new int[]{0, 0, 0};
    arr2 = new int[]{1, 1, 1};
    longestSubArrayWithSameSum(arr1, arr2);

    arr1 = new int[]{0, 0, 1, 0};
    arr2 = new int[]{1, 1, 1, 1};
    longestSubArrayWithSameSum(arr1, arr2);
  }
}
