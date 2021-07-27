package array.problems;

import java.util.Arrays;

public class Problem004 {

  /**
   * Brute Force Way: would be to perform two for loops and check every element with one another. Time : O(n2)
   *
   * Since we are finding the sum which is close to 0 so we should always have some negative
   * elements. If the array can have only negative or only positive elements, then we can handle
   * such scenario by sorting the array and finding the max difference between consecutive elements.
   */
  public static void findPairClosestToZero(int arr[]) {
    Arrays.sort(arr);
    String pair = "";
    int minDiff = Integer.MAX_VALUE;
    int i=0, j=  arr.length-1;

    while(i < j) {
      int left = arr[i];
      int right = arr[j];
      int diff;

      diff = left + right;

      if(Math.abs(diff) < minDiff) {
        minDiff = Math.abs(diff);
        pair = arr[i] + " : " + arr[j];
      }

      if(diff < 0) {
        i++;
      }
      else {
        j--;
      }
    }

    System.out.println("Pair closest to 0: " + pair);
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,60,-10,70,-80,85};
    System.out.println(Arrays.toString(arr));
    findPairClosestToZero(arr);
  }

}
